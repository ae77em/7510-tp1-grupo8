package tp1_7510.grupo8.ConfigurationLoaders;

import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tp1_7510.grupo8.CONSTANTS.PathLogs;

public class Configurator {
    private LoaderConfiguration loaderConfiguration;
    private ParserJsonConfig parserJsonConfig;
    
    /*
     * se usa solamente en los test para forzar la configuracion desde un properties
     */
    public Configurator(String pathFileConfig){
    	loaderConfiguration = new LoaderPropertiesConfiguration(pathFileConfig);

    	parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
    }	


    public Configurator(){
    	String pathProperties = PathLogs.PATH_CONFIG + "config.properties";
    	String pathXml = PathLogs.PATH_CONFIG + "config.xml";
    	
    	if (existsFile(pathProperties)){
    		loaderConfiguration = new LoaderPropertiesConfiguration(pathProperties);
    	}
        else if (existsFile(pathXml)){
        	loaderConfiguration = new LoaderXmlConfiguration(pathXml);
    	}else{
        	loaderConfiguration = new LoaderDefaultConfiguration();        		
    	}         
   	        	        	
    	parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
    }	
    
    private boolean existsFile(String pathFile) {        	
    	return new File(pathFile).exists();
	}

	public JSONArray getConfigurationLogger(){
    	return parserJsonConfig.getConfigLoggers();
    }
}