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

		public JSONObject getConfigurationLogger(){
        	return parserJsonConfig.getConfigLoggers();
        }
}