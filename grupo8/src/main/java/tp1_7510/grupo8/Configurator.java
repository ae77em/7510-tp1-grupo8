package tp1_7510.grupo8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.w3c.dom.Element;

import tp1_7510.grupo8.CONSTANTS.PathLogs;

public class Configurator {
                
        private LoaderConfiguration loaderConfiguration;
        private ParserJsonConfig parserJsonConfig;

        public Configurator(){
        	String pathProperties = PathLogs.PATH_CONFIG + "config.properties";
        	String pathXml = PathLogs.PATH_CONFIG + "config.xml";
        	
        	File ficheroProperties = new File(pathProperties);
        	File ficheroXml = new File(pathXml);
        	        	
        	if (ficheroProperties.exists()){//CODGIO PARA VER QUE OFRMATO DE CONFIGURAION SE LEVANTA
        		loaderConfiguration = new LoaderPropertiesConfiguration(pathProperties);
        	}
            else if (ficheroXml.exists()){//CODGIO PARA VER QUE OFRMATO DE CONFIGURAION SE LEVANTA
            	loaderConfiguration = new LoaderXmlConfiguration(pathXml);
        	}else{
            	loaderConfiguration = new LoaderDefaultConfiguration();        		
        	}         
        	        	
        	parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
        }	
        
        public JSONObject getConfigurationLogger(){
        	return parserJsonConfig.getConfigLoggers();
        }
}