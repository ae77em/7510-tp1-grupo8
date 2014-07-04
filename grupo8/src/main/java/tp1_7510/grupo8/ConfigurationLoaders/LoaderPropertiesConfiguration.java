package tp1_7510.grupo8.ConfigurationLoaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

/*
 * leventa la configuracion desde un properties
 */
public class LoaderPropertiesConfiguration implements LoaderConfiguration{
	
	private Properties properties;
	private ArrayList<Hashtable<String,String>> vecConfigurations = new ArrayList<Hashtable<String,String>>();

	public LoaderPropertiesConfiguration(String pathConfig){	
		loadProperties(pathConfig);
		
		loadVecProperties();
	}

	private void loadProperties(String pathConfig) {
		properties = new Properties();
        
	    try {
	         properties.load(new FileInputStream(pathConfig));
	    } catch (IOException ex) {
	         ex.printStackTrace();
	    }
	}
	
	private void loadVecProperties() {
		loadFiles();
		
		loadJsons();
		
		loadConsole();
	}

	private void loadConsole() {
		String console = (String) properties.get("CONSOLES");
		
		if(console.equals("ON"))
			vecConfigurations.add( getConfiguration("console") );
		
	}

	private void loadJsons() {
		String[] jsons = getNamesPrinters("JSON");
			
		for(String aJson: jsons){
			vecConfigurations.add( getConfiguration(aJson) );
		}
	}

	private void loadFiles() {
		String[] files = getNamesPrinters("FILES");
		
		for(String aFile: files){
			vecConfigurations.add( getConfiguration(aFile) );
		}
	}

	private Hashtable<String,String> getConfiguration( String aFile ) {
		Hashtable<String,String> aConfig = new Hashtable<String,String>();
		
		aConfig.put("name", aFile);
		aConfig.put("fileName", properties.getProperty(aFile+"-fileName"));
		aConfig.put("type", properties.getProperty(aFile+"-type"));
		aConfig.put("levelLog", properties.getProperty(aFile+"-levelLog"));
		aConfig.put("formatDate", properties.getProperty(aFile+"-formatDate"));
		aConfig.put("patternMessage", properties.getProperty(aFile+"-patternMessage"));
		aConfig.put("separator", properties.getProperty(aFile+"-separator"));
		aConfig.put("regularExpresion", properties.getProperty(aFile+"-regularExpresion"));
		aConfig.put("customFilter", properties.getProperty(aFile+"-customFilter"));
		aConfig.put("customClassName", properties.getProperty(aFile+"-customClassName"));
				
		putFilterCustom(aConfig);
		
		return aConfig;	
	}

	private void putFilterCustom(Hashtable<String, String> aConfig) {
		String[] filters = aConfig.get("customFilter").split(",");
		
		String namePrinter = aConfig.get("name"); 
		
		for(String aFilter : filters){
			aConfig.put(aFilter, properties.getProperty(namePrinter+"-"+aFilter));
		}
	}
	
	private String[] getNamesPrinters(String typePrinter) {
		
		String files = (String) properties.get(typePrinter); 
		return files.split(",");
	}

	public int getLenghtLoggers() {
		
		return vecConfigurations.size();
	}


	public String getNameLogger(int i) {
		
		return vecConfigurations.get(i).get("name");
	}


	public String getTypeLogger(int i) {
		
		return vecConfigurations.get(i).get("type");
	}


	public String getFileNameLogger(int i) {
		
		return vecConfigurations.get(i).get("fileName");
	}


	public String getLogLevelLogger(int i) {
		
		return vecConfigurations.get(i).get("levelLog");
	}


	public String getFormatDateLogger(int i) {
		
		return vecConfigurations.get(i).get("formatDate");
	}


	public String getPatternMessageLogger(int i) {
		
		return vecConfigurations.get(i).get("patternMessage");
	}


	public String getSeparatorLogger(int i) {
		
		return vecConfigurations.get(i).get("separator");
	}


	public String getRegularExpresionLogger(int i) {
		
		return vecConfigurations.get(i).get("regularExpresion");
	}


	public Hashtable<String, String> getCustomFilterLogger(int i) {
		Hashtable<String, String> aCustomFilters = new Hashtable<String, String>();
		
		String[] filters = vecConfigurations.get(i).get("customFilter").split(",");
		
		for(String aFilter : filters){
			aCustomFilters.put(aFilter, vecConfigurations.get(i).get(aFilter));
		}

		return aCustomFilters;
	}

	public String getCustomClassNameLogger(int i) {
		
		return vecConfigurations.get(i).get("customClassName");
	}

}
