package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import tp1_7510.grupo8.Patterns.*;

public class Configurer {
 	 	
	private Properties prop;
	
	//-----------------------------------------------
	Configurer(){
		prop = new Properties();
		
		loadDefaultProperties();
	}

	//-----------------------------------------------
	public void loadDefaultProperties(){
		prop.setProperty("files","");
		prop.setProperty("consoles","consoleDefault,");	
		prop.setProperty("consoleDefault-separator", "-");
		prop.setProperty("consoleDefault-logLevel", "DEBUG");
		prop.setProperty("consoleDefault-formatDate", "%d{HH:mm:ss}");
		prop.setProperty("consoleDefault-format", "%d{HH:mm:ss}-%p-%t-%m");
	}
	
	public void createPrinter(String printer,String name){
		String consoles = prop.getProperty(printer);
		
		consoles += name + ","; 
		
		prop.setProperty(printer,consoles);
		
		createDefaultsSetting(name);
	}
		
	private void createDefaultsSetting(String aPrinter) {
		prop.setProperty(aPrinter+"-separator", "-");
		prop.setProperty(aPrinter+"-logLevel", "DEBUG");
		prop.setProperty(aPrinter+"-formatDate", "%d{HH:mm:ss}");
		prop.setProperty(aPrinter+"-format", "%d{HH:mm:ss}-%p-%t-%m");
	}

	public void eraseDefaultConsole() {		
		String consoles = prop.getProperty("consoles");
		
		consoles = consoles.replace("consoleDefault,","");
		
		prop.setProperty("consoles",consoles);
		
		prop.remove("consoleDefault-separator");
		prop.remove("consoleDefault-logLevel");
		prop.remove("consoleDefault-formatDate");
		prop.remove("consoleDefault-format");
	}

	/**************SETTERS*************************/
	public void setFormatDate(String aPrinter, String formatDate){
		prop.setProperty(aPrinter+"-formatDate", formatDate);
	}
	
	public void setFormatMessage(String aPrinter, String formatMessage){
		prop.setProperty(aPrinter+"-format", formatMessage);
	}
	
	public void setLogLevel(String aPrinter, String logLevel){
		prop.setProperty(aPrinter+"-logLevel", logLevel);
	}
	
	public void setSeparator(String aPrinter, String separator){
		prop.setProperty(aPrinter+"-separator", separator);
	}
	
	public String getFiles() {
		// TODO Auto-generated method stub
		return prop.getProperty("files");
	}

	/**************GETTERS*************************/
	public String getConsoles() {
		// TODO Auto-generated method stub
		return prop.getProperty("consoles");
	}
	
	public Properties getProperties(){
		return prop;
	}
	
	public String getFormatDate(String aPrinter){
		return prop.getProperty(aPrinter+"-formatDate");
	}
	
	public String getFormatMessage(String aPrinter){
		return prop.getProperty(aPrinter+"-format");
	}
	
	public String getLogLevel(String aPrinter){
		return prop.getProperty(aPrinter+"-logLevel");
	}
	
	public String getSeparator(String aPrinter){
		return prop.getProperty(aPrinter+"-separator");
	}
	
	//-----------------------------------------------
	/*INI ACCESO A DISCO**/
	public void saveProperties(){
		OutputStream output = null;
	 
		try {
			output = new FileOutputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
			 
			prop.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	//-----------------------------------------------
	public void loadProperties(){
		InputStream input = null;
	 
		try {
			input = new FileInputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");	 
			// load a properties file
			prop.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*ACCESO A PROPIEDADES DE PRINTERS**/
	public ArrayList<Hashtable<String, String>> getPrintersConfiguration(String printer) {
		ArrayList<Hashtable<String, String>> printersConfiguration = new ArrayList<Hashtable<String, String>>();
		
		String printers = prop.getProperty(printer);
		
		if(printers.length()<=1){
			return printersConfiguration;
		}
		//
		String[] aPrinters = printers.split(",");
		
		for(int i=0; i<aPrinters.length;i++){
			printersConfiguration.add( getPrinterConfiguration(aPrinters[i]));
		}

		return printersConfiguration;
	}

	public Hashtable<String, String> getPrinterConfiguration(String aPrinter) {
		Hashtable<String, String> dataConfiguration = new Hashtable<String, String>();
		
		dataConfiguration.put("name", aPrinter);
		dataConfiguration.put("separator", prop.getProperty(aPrinter+"-separator"));
		dataConfiguration.put("logLevel", prop.getProperty(aPrinter+"-logLevel"));
		dataConfiguration.put("formatDate", prop.getProperty(aPrinter+"-formatDate"));
		dataConfiguration.put("format", prop.getProperty(aPrinter+"-format"));
				
		return dataConfiguration;
	}
	
	public Hashtable<String,ArrayList<Hashtable<String, String>>> getPrintersConfiguration(){
		Hashtable<String,ArrayList<Hashtable<String, String>>> printers = new Hashtable<String,ArrayList<Hashtable<String, String>>>();
		
		printers.put("FILES", getPrintersConfiguration("files"));
		printers.put("CONSOLES", getPrintersConfiguration("consoles"));
		
		return printers;
	}
}

