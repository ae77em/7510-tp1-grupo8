package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

public class Configurator {
 	 	
	private Properties properties;
	
	Configurator(){
		properties = new Properties();
		
		loadDefaultProperties();
		loadProperties();
	}

	public void loadDefaultProperties(){
		properties.setProperty("files","");
		properties.setProperty("consoles","consoleDefault,");	
		properties.setProperty("consoleDefault-separator", "-");
		properties.setProperty("consoleDefault-logLevel", LogLevel.DEBUG.toString());
		properties.setProperty("consoleDefault-formatDate", "%d{HH:mm:ss}");
		properties.setProperty("consoleDefault-format", "%d{HH:mm:ss}-%n-%p-%n-%m");
	}
	
	public void createPrinter(String printer,String name){
		String consoles = properties.getProperty(printer);
		
		consoles += name + ","; 
		
		properties.setProperty(printer,consoles);
		
		createDefaultsSetting(name);
	}
		
	private void createDefaultsSetting(String aPrinter) {
		properties.setProperty(aPrinter+"-separator", "-");
		properties.setProperty(aPrinter+"-logLevel", "DEBUG");
		properties.setProperty(aPrinter+"-formatDate", "%d{HH:mm:ss}");
		properties.setProperty(aPrinter+"-format", "%d{HH:mm:ss}-%p-%t-%m");
	}

	public void eraseDefaultConsole() {		
		String consoles = properties.getProperty("consoles");
		
		consoles = consoles.replace("consoleDefault,","");
		
		properties.setProperty("consoles",consoles);
		
		properties.remove("consoleDefault-separator");
		properties.remove("consoleDefault-logLevel");
		properties.remove("consoleDefault-formatDate");
		properties.remove("consoleDefault-format");
	}

	public void setFormatDate(String aPrinter, String formatDate){
		properties.setProperty(aPrinter+"-formatDate", formatDate);
	}
	
	public void setFormatMessage(String aPrinter, String formatMessage){
		properties.setProperty(aPrinter+"-format", formatMessage);
	}
	
	public void setLogLevel(String aPrinter, LogLevel ll){
		properties.setProperty(aPrinter+"-logLevel", ll.toString());
	}
	
	public void setSeparator(String aPrinter, String separator){
		properties.setProperty(aPrinter+"-separator", separator);
	}
	
		public String getFiles() {
		return properties.getProperty("files");
	}
	public String getConsoles() {
		return properties.getProperty("consoles");
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public String getFormatDate(String aPrinter){
		return properties.getProperty(aPrinter+"-formatDate");
	}
	
	public String getFormatMessage(String aPrinter){
		return properties.getProperty(aPrinter+"-format");
	}
	
	public LogLevel getLogLevel(String aPrinter){
		return LogLevel.valueOf(properties.getProperty(aPrinter+"-logLevel"));
	}
	
	public String getSeparator(String aPrinter){
		return properties.getProperty(aPrinter+"-separator");
	}
	
	public void saveProperties(){
		OutputStream output = null;
	 
		try {
			output = new FileOutputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
			 
			properties.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	private void loadProperties(){
		InputStream input = null;
	 
		try {
			input = new FileInputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");	 
			properties.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Hashtable<String, String>> getPrintersConfiguration(String printer) {
		ArrayList<Hashtable<String, String>> printersConfiguration = new ArrayList<Hashtable<String, String>>();
		
		String printers = properties.getProperty(printer);
		
		if(printers.length()<=1){
			return printersConfiguration;
		}

		String[] aPrinters = printers.split(",");
		
		for(int i=0; i<aPrinters.length;i++){
			printersConfiguration.add( getPrinterConfiguration(aPrinters[i]));
		}

		return printersConfiguration;
	}

	public Hashtable<String, String> getPrinterConfiguration(String aPrinter) {
		Hashtable<String, String> dataConfiguration = new Hashtable<String, String>();
		
		dataConfiguration.put("name", aPrinter);
		dataConfiguration.put("separator", properties.getProperty(aPrinter+"-separator"));
		dataConfiguration.put("logLevel", properties.getProperty(aPrinter+"-logLevel"));
		dataConfiguration.put("formatDate", properties.getProperty(aPrinter+"-formatDate"));
		dataConfiguration.put("format", properties.getProperty(aPrinter+"-format"));
				
		return dataConfiguration;
	}
	
	public Hashtable<String, ArrayList<Hashtable<String, String>>> getPrintersConfiguration(){
		Hashtable<String, ArrayList<Hashtable<String, String>>> printers = new Hashtable<String, ArrayList<Hashtable<String, String>>>();
		
		printers.put("FILES", getPrintersConfiguration("files"));
		printers.put("CONSOLES", getPrintersConfiguration("consoles"));
		
		return printers;
	}
}

