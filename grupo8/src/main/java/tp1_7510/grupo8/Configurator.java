package tp1_7510.grupo8;

import java.io.File;
import org.json.simple.JSONObject;
import tp1_7510.grupo8.CONSTANTS.PathLogs;

public class Configurator {
                
        private LoaderConfiguration loaderConfiguration;
        private ParserJsonConfig parserJsonConfig;

        public Configurator(){
        	String pathProperties = PathLogs.PATH_CONFIG + "config.properties";
        	String pathXml = PathLogs.PATH_CONFIG + "config.xml";
        	
        	File ficheroProperties = new File(pathProperties);
        	File ficheroXml = new File(pathXml);
        	        	
       /* 	if (ficheroProperties.exists()){//CODGIO PARA VER QUE OFRMATO DE CONFIGURAION SE LEVANTA
        		loaderConfiguration = new LoaderPropertiesConfiguration(pathProperties);
        	}
            else if (ficheroXml.exists()){//CODGIO PARA VER QUE OFRMATO DE CONFIGURAION SE LEVANTA
            	loaderConfiguration = new LoaderXmlConfiguration(pathXml);
        	}else{
            	loaderConfiguration = new LoaderDefaultConfiguration();        		
        	}         
        */	        	
        	loaderConfiguration = new LoaderPropertiesConfiguration(pathProperties);
        	
        	parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
        }	
        
        public JSONObject getConfigurationLogger(){
        	return parserJsonConfig.getConfigLoggers();
        }
}