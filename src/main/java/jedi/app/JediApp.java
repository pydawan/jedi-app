package jedi.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarInputStream;

/**
 * @author thiago-amm
 * @version v1.0.0
 * @since v1.0.0
 */
@SuppressWarnings("rawtypes")
public class JediApp {
   
   private String name;
   private String verboseName;
   private String verboseNamePlural;
   private String label;
   private String dbTable;
   private String[] authors;
   private String version;
   private String description;
   private String date;
   private Class mainClass;
   private Map classes = new HashMap<>();
   private JarInputStream jar;
   
   @SuppressWarnings("unchecked")
   public JediApp() {
      this.classes.put("models", new ArrayList<>());
   }
   
   public String getName() {
      return this.name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getVerboseName() {
      return this.verboseName;
   }
   
   public void setVerboseName(String verboseName) {
      this.verboseName = verboseName;
   }
   
   public String getVerboseNamePlural() {
      return this.verboseNamePlural;
   }
   
   public void setVerboseNamePlural(String verboseNamePlural) {
      this.verboseNamePlural = verboseNamePlural;
   }
   
   public String getLabel() {
      return this.label;
   }
   
   public void setLabel(String label) {
      this.label = label;
   }
   
   public String getDBTable() {
      return this.dbTable;
   }
   
   public void setDBTable(String dbTable) {
      this.dbTable = dbTable;
   }
   
   public String[] getAuthors() {
      return this.authors;
   }
   
   public void setAuthors(String[] authors) {
      this.authors = authors;
   }
   
   public String getVersion() {
      return this.version;
   }
   
   public void setVersion(String version) {
      this.version = version;
   }
   
   public String getDescription() {
      return this.description;
   }
   
   public void setDescription(String description) {
      this.description = description;
   }
   
   public String getDate() {
      return this.date;
   }
   
   public void setDate(String date) {
      this.date = date;
   }
   
   public Class getMainClass() {
      return this.mainClass;
   }
   
   public void setMainClass(Class mainClass) {
      this.mainClass = mainClass;
   }
   
   public Map getClasses() {
      return this.classes;
   }
   
   public void setClasses(Map classes) {
      this.classes = classes;
   }
   
   public JarInputStream getJar() {
      return this.jar;
   }
   
   public void setJar(JarInputStream jar) {
      this.jar = jar;
   }
   
}
