package tp1_7510.grupo8.Logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.JsonPrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	private FileWriter errorWriter;	
	private Printer printer;
	
	public static String message = "", level = "";	
	
	public Logger(JSONObject jsonConfig){	
		generatePrinter(jsonConfig);		
	}
	
	
	private void generatePrinter(JSONObject jsonConfig){
		Hashtable<String,String> configPatter = getConfigPattern(jsonConfig); 
		
		Hashtable<String,String> filterCustom = getFilterCustom((JSONArray)jsonConfig.get("customFilter"));//obtenerConfigPatter
			
		String typePrinter = (String) jsonConfig.get("type");
		
		switch(typePrinter){
		 case "FILES":
		     try {
				printer = new FilePrinter(configPatter,filterCustom);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		     break;
		 case "CONSOLES":					
			 printer = new ConsolePrinter(configPatter,filterCustom);
		     break;
		 case "JSON":  
			 try {
				printer = new JsonPrinter(configPatter,filterCustom);
			 } catch (FileNotFoundException e) {
				e.printStackTrace();
			 }
		     break;
		 case "CUSTOM":  
			 createCustomClass(jsonConfig, configPatter, filterCustom);
		     break;
		 }
	}


	private void createCustomClass(JSONObject jsonConfig,
			Hashtable<String, String> configPatter,
			Hashtable<String, String> filterCustom) {
		try {				 
			 	String customClassName = customClassName((JSONArray)jsonConfig.get("type"));
				Class<? extends Printer> customPrinterClass = getCustomClass(customClassName);
				try {
					try {
						printer = (Printer) customPrinterClass.getDeclaredConstructor(customPrinterClass).newInstance(configPatter,filterCustom);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}						
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}			 
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		 }
	}


	private Class<? extends Printer> getCustomClass(String className) throws ClassNotFoundException {
		return (Class<? extends Printer>) Class.forName(className);
	}
	
	private String customClassName(JSONArray jsonArray){
				
		JSONObject obj = (JSONObject) jsonArray.get(0);
		JSONObject key = (JSONObject) obj.get("className");
				
		
		return key.toString();
		
	}

	private Hashtable<String, String> getFilterCustom(JSONArray jsonArray) {
		Hashtable<String,String> hashFilterCustom = new Hashtable<String,String>();
		
		for(int i=0; i<jsonArray.size();i++){
			JSONObject obj = (JSONObject) jsonArray.get(i);
			JSONObject key = (JSONObject) obj.get("key");
			
			hashFilterCustom.put(key.get("pattern").toString(),key.get("value").toString());
		}
		
		return hashFilterCustom;
	}

	private Hashtable<String, String> getConfigPattern(JSONObject jsonConfig) {
		Hashtable<String,String> configPattern = new Hashtable<String,String>();
		
		configPattern.put("logLevel", (String)jsonConfig.get("levelLog"));
		configPattern.put("separator", (String)jsonConfig.get("separator"));
		configPattern.put("formatDate", (String)jsonConfig.get("formatDate"));
		configPattern.put("name", (String)jsonConfig.get("fileName"));
		configPattern.put("format", (String)jsonConfig.get("patternMessage"));
		configPattern.put("namePrinter", (String)jsonConfig.get("name"));
		configPattern.put("regularExpresion", (String)jsonConfig.get("regularExpresion"));
				
		return configPattern;
	}

	private void log(String aMessage,LogLevel aLogLevel) {
		message = aMessage;
		level = aLogLevel.toString();
		
		String messageFormated = printer.formatMessage();
			
		if(printer.isMessageOk(aMessage,aLogLevel)){
    		printer.print( messageFormated );
    	}else{
        	writeErrorFile(printer.getErrorMessage());        	
    	}
	}
	
	private void writeErrorFile(String output) {
		
		openErrorFile();		
		
		try {
			errorWriter.write(getHour()+" - Desc: "+output+System.getProperty("line.separator"));
            System.out.println(getHour() + " - Desc: "+output);            
 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
		
		closeErrorFile();
	}
	
	private String getHour(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Calendar cal = Calendar.getInstance();
    	    	
    	return sdf.format(cal.getTime());
	}
	
	private void openErrorFile(){
		try {
			errorWriter = new FileWriter( PathLogs.PATH_ERROR + "error.dat",true );						
			//errorWriter = new PrintWriter( new File (PathLogs.PATH_ERROR + "error.dat" ) );			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String FormatMessageWithException(String message, Throwable tr) {
		message += ". Exception: " + tr.getLocalizedMessage();
		return message;
	}
	
	public void off(String message){
		log(message,LogLevel.OFF);
	}
	
	public void fatal(String message){
		log(message,LogLevel.FATAL);
	}
	
	public void error(String message){
		log(message,LogLevel.ERROR);
	}
	
	public void warn(String message){
		log(message,LogLevel.WARN);
	}
	
	public void info(String message){
		log(message,LogLevel.INFO);
	}
	
	public void debug(String message){
		log(message,LogLevel.DEBUG);
	}
	
	public void trace(String message){
		log(message,LogLevel.TRACE);
	}	
	
	public void off(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.OFF);		
	}
	
	public void fatal(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.FATAL);		
	}
	
	public void error(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.ERROR);		
	}
	
	public void warn(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.WARN);		
	}
	
	public void info(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.INFO);		
	}
	
	public void debug(String message, Throwable tr){
		log(FormatMessageWithException(message, tr),LogLevel.DEBUG);		
	}
	
	public void trace(String message, Throwable tr){		
		log(FormatMessageWithException(message, tr),LogLevel.TRACE);
		
	}	

	public void close() {		
		printer.close();
	}	
	
	public void closeErrorFile() {		
		try {        	
        	errorWriter.flush();
        	errorWriter.close();        				
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
