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
   private String packageName;
   private Class mainClass;
   private Map<String, Object> classes = new HashMap<>();
   private JarInputStream jar;
   
   public JediApp() {
      this.classes.put("models", new ArrayList<Class<?>>());
   }
   
   public String getName() {
      return this.name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String name() {
      return getName();
   }
   
   public JediApp name(String name) {
      setName(name);
      return this;
   }
   
   public String getVerboseName() {
      return this.verboseName;
   }
   
   public void setVerboseName(String verboseName) {
      this.verboseName = verboseName;
   }
   
   public String verboseName() {
      return getVerboseName();
   }
   
   public JediApp verboseName(String verboseName) {
      setVerboseName(verboseName);
      return this;
   }
   
   public String getVerboseNamePlural() {
      return this.verboseNamePlural;
   }
   
   public void setVerboseNamePlural(String verboseNamePlural) {
      this.verboseNamePlural = verboseNamePlural;
   }
   
   public String verboseNamePlural() {
      return getVerboseNamePlural();
   }
   
   public JediApp verboseNamePlural(String verboseNamePlural) {
      setVerboseNamePlural(verboseNamePlural);
      return this;
   }
   
   public String getLabel() {
      return this.label;
   }
   
   public void setLabel(String label) {
      this.label = label;
   }
   
   public String label() {
      return getLabel();
   }
   
   public JediApp label(String label) {
      setLabel(label);
      return this;
   }
   
   public String getDBTable() {
      return this.dbTable;
   }
   
   public void setDBTable(String dbTable) {
      this.dbTable = dbTable;
   }
   
   public String dbTable() {
      return this.dbTable;
   }
   
   public JediApp dbTable(String dbTable) {
      setDBTable(dbTable);
      return this;
   }
   
   public String[] getAuthors() {
      return this.authors;
   }
   
   public void setAuthors(String[] authors) {
      this.authors = authors;
   }
   
   public String[] authors() {
      return getAuthors();
   }
   
   public JediApp authors(String[] authors) {
      setAuthors(authors);
      return this;
   }
   
   public String getVersion() {
      return this.version;
   }
   
   public void setVersion(String version) {
      this.version = version;
   }
   
   public String version() {
      return getVersion();
   }
   
   public JediApp version(String version) {
      setVersion(version);
      return this;
   }
   
   public String getDescription() {
      return this.description;
   }
   
   public void setDescription(String description) {
      this.description = description;
   }
   
   public String description() {
      return this.description;
   }
   
   public JediApp description(String description) {
      setDescription(description);
      return this;
   }
   
   public String getDate() {
      return this.date;
   }
   
   public void setDate(String date) {
      this.date = date;
   }
   
   public String date() {
      return this.date;
   }
   
   public JediApp date(String date) {
      setDate(date);
      return this;
   }
   
   public String getPackageName() {
      return packageName;
   }
   
   public void setPackageName(String packageName) {
      this.packageName = packageName;
   }
   
   public String packageName() {
      return getPackageName();
   }
   
   public JediApp packageName(String packageName) {
      setPackageName(packageName);
      return this;
   }
   
   public Class getMainClass() {
      return this.mainClass;
   }
   
   public void setMainClass(Class mainClass) {
      this.mainClass = mainClass;
   }
   
   public Class mainClass() {
      return getMainClass();
   }
   
   public JediApp mainClass(Class mainClass) {
      setMainClass(mainClass);
      return this;
   }
   
   public Map getClasses() {
      return this.classes;
   }
   
   public void setClasses(Map<String, Object> classes) {
      this.classes = classes;
   }
   
   public Map classes() {
      return getClasses();
   }
   
   public JediApp classes(Map<String, Object> classes) {
      setClasses(classes);
      return this;
   }
   
   public JarInputStream getJar() {
      return this.jar;
   }
   
   public void setJar(JarInputStream jar) {
      this.jar = jar;
   }
   
   public JarInputStream jar() {
      return getJar();
   }
   
   public JediApp jar(JarInputStream jar) {
      setJar(jar);
      return this;
   }
   
}
