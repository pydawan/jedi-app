package jedi.app.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import jedi.app.JediApp;

/**
 * @author thiago-amm
 * @version v1.0.0
 * @since v1.0.0
 */
@SuppressWarnings("rawtypes")
public abstract class JediAppLoader {
   
   private static String dir;
   private static Map apps = new HashMap<>();
   
   public static String getDir() {
      return dir;
   }
   
   public static void setDir(String dir) {
      JediAppLoader.dir = dir;
   }
   
   public static Map getApps() {
      return apps;
   }
   
   public static void setApps(Map apps) {
      JediAppLoader.apps = apps;
   }
   
   @SuppressWarnings("unchecked")
   public static void load(String appName) {
      appName = appName == null ? "" : appName.trim();
      if (!appName.isEmpty()) {
         JarInputStream jar = null;
         String path = String.format("%s%s%s.jar", new Object[] { dir, File.separator, appName });
         File file = new File(path);
         if (file.exists()) {
            try {
               jar = new JarInputStream(new FileInputStream(file));
               Manifest e = jar.getManifest();
               String className = e.getMainAttributes().getValue("Main-Class");
               Class clazz = Class.forName(className);
               JediApp app = new JediApp();
               app.setJar(jar);
               app.setMainClass(clazz);
               jedi.app.annotation.JediApp jediAppAnnotation = (jedi.app.annotation.JediApp) clazz
                  .getAnnotation(jedi.app.annotation.JediApp.class);
               if (jediAppAnnotation != null) {
                  String jarEntry = jediAppAnnotation.name() == null ? "" : jediAppAnnotation.name().trim();
                  String verboseName = jediAppAnnotation.verbose_name() == null ? 
                     "" : jediAppAnnotation.verbose_name().trim();
                  String verboseNamePlural = jediAppAnnotation.verbose_name_plural() == null
                     ? "" : jediAppAnnotation.verbose_name_plural().trim();
                  String label = jediAppAnnotation.label() == null ? "" : jediAppAnnotation.label().trim();
                  String dbTable = jediAppAnnotation.db_table() == null ? "" : jediAppAnnotation.db_table().trim();
                  String[] authors = jediAppAnnotation.authors() == null ? 
                     new String[] { "" } : jediAppAnnotation.authors();
                  String version = jediAppAnnotation.version() == null ? "" : jediAppAnnotation.version().trim();
                  String description = jediAppAnnotation.description() == null ? 
                     "" : jediAppAnnotation.description().trim();
                  String date = jediAppAnnotation.date() == null ? "" : jediAppAnnotation.date().trim();
                  app.setName(jarEntry);
                  app.setVerboseName(verboseName);
                  app.setVerboseNamePlural(verboseNamePlural);
                  app.setLabel(label);
                  if (dbTable.isEmpty()) {
                     app.setDBTable(JediAppLoader.getTableName(app.getName()));
                  }
                  app.setAuthors(authors);
                  app.setVersion(version);
                  app.setDescription(description);
                  app.setDate(date);
               }
               while (true) {
                  JarEntry jarEntry1 = jar.getNextJarEntry();
                  if (jarEntry1 == null) {
                     apps.put(appName, app);
                     break;
                  }
                  if (
                     jarEntry1.getName().replace(File.separator, ".").startsWith(appName) && 
                     jarEntry1.getName().endsWith(".class") &&
                     jarEntry1.getName().contains("models")) {
                     className = appName.replaceAll("\\.", "/") + "/models/";
                     if (jarEntry1.getName().startsWith(className)) {
                        className = jarEntry1.getName().replaceAll("/", "\\.");
                        className = className.replace(".class", "");
                        clazz = Class.forName(className);
                        ((List) app.getClasses().get("models")).add(clazz);
                     }
                  }
               }
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            } catch (IOException e) {
               e.printStackTrace();
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
            } finally {
               if (jar != null) {
                  try {
                     jar.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      }
   }
   
   public static JediApp get(String appName) {
      JediApp app = null;
      appName = appName == null ? "" : appName.trim();
      if (!appName.isEmpty()) {
         if (apps.isEmpty()) {
            load(appName);
         }
         app = (JediApp) apps.get(appName);
      }
      return app;
   }
   
   public static final String getTableName(String className) {
      className = className == null ? "" : className.trim();
      String tableName = "";
      if (!className.isEmpty()) {
         if (className.matches("([A-Z](\\w+))+")) {
            String[] words = className.split("(?=[A-Z])");
            if (words != null) {
               if (words.length == 1) {
                  className = String.format("%ss", className);
               } else if (words.length >= 2) {
                  className = "";
                  for (String word : words) {
                     if (!word.isEmpty()) {
                        className += String.format("%ss", word);
                     }
                  }
               } else {
                  
               }
            }
         }
         className = className.trim();
         className = className.replaceAll("([a-z0-9]+)([A-Z])", "$1_$2");
         className = className.toLowerCase();
         tableName = className;
      }
      return tableName;
   }
   
}
