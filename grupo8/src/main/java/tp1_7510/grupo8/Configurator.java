package tp1_7510.grupo8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.w3c.dom.Element;

public class Configurator {
                
        private LoaderConfiguration loaderConfiguration;
        private ParserJsonConfig parserJsonConfig;

        Configurator(String pathConfig){
        	String path = "src/main/java/tp1_7510/grupo8/Config/config.xml";
        	File fichero = new File(path);
        	        	
        	/*if (fichero.exists())
        		loaderConfiguration = new LoaderPropertiesConfiguration(path);
            else
            	System.out.println("el fichero no existe");*/
        	
        	//loaderConfiguration = new LoaderPropertiesConfiguration(path);
        	loaderConfiguration = new LoaderXmlConfiguration(path);
        	//loaderConfiguration = new LoaderDefaultConfiguration();
        	
        	parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
        	
        	loaderConfiguration.getCustomFilterLogger(0);
        	
        }	


		
		private void loadPropertiesConfig() {
			/*properties = new Properties();
            
            InputStream input = null;
             
            try {
                   // input = new FileInputStream(pathProperties);     
                    properties.load(input);
             
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
            
            try {
                    input.close();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
*/
			
		}

		public String getFiles() {
                return "";//properties.getProperty(LogOutput.FILES.toString());
        }
        public String getConsoles() {
                return "";//properties.getProperty(LogOutput.CONSOLES.toString());
        }
        
        public Properties getProperties(){
                return null;//properties;
        }
        
        public ArrayList<Hashtable<String, String>> getPrintersConfiguration(LogOutput logOutput) {
                
                ArrayList<Hashtable<String, String>> printersConfiguration = new ArrayList<Hashtable<String, String>>();
        /*        String printersFromProperties = "";
                String[] printers;
                
                printersFromProperties += properties.getProperty(logOutput.toString());
                                
                if ( printersFromProperties.equals("null")){ 
                        return printersConfiguration;
                }

                printers = printersFromProperties.split(","); 
                
                for(String printer : printers){
            	    printersConfiguration.add( getPrinterConfiguration(printer));
                }
*/
                return printersConfiguration;
        }

        public Hashtable<String, String> getPrinterConfiguration(String namePrinter) {
                
                Hashtable<String, String> dataConfiguration = new Hashtable<String, String>();
  /*              dataConfiguration.put("name", namePrinter);
                dataConfiguration.put("separator", properties.getProperty(namePrinter+"-separator"));
                dataConfiguration.put("logLevel", properties.getProperty(namePrinter+"-logLevel"));
                dataConfiguration.put("formatDate", properties.getProperty(namePrinter+"-formatDate"));
                dataConfiguration.put("format", properties.getProperty(namePrinter+"-format"));
    */                                            
                return dataConfiguration;
        }
        
        public Hashtable<String, ArrayList<Hashtable<String, String>>> getPrintersConfiguration(){
                Hashtable<String, ArrayList<Hashtable<String, String>>> printers = new Hashtable<String, ArrayList<Hashtable<String, String>>>();
                
                printers.put(LogOutput.FILES.toString(), getPrintersConfiguration(LogOutput.FILES));
                printers.put(LogOutput.CONSOLES.toString(), getPrintersConfiguration(LogOutput.CONSOLES));
                
                return printers;
        }
}