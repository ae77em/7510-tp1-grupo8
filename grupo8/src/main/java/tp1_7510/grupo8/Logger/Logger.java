package tp1_7510.grupo8.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.lang.Exception;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.JsonPrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	PrintWriter errorWriter;	
	public static String message = "", level = "";	
	private Printer printer;
	
	
	public Logger(JSONObject jsonConfig){
		
		generatePrinter(jsonConfig);
		
		try {
			errorWriter = new PrintWriter( new File (PathLogs.PATH_ERROR + "error.dat" ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	private void generatePrinter(JSONObject jsonConfig){
		//System.out.println(jsonConfig.toJSONString());
		Hashtable<String,String> configPatter = getConfigPattern(jsonConfig);//obtenerConfigPatter
		
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
		 }
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
        	errorWriter.println(printer.getErrorMessage());
    	}
	}
	
	private String FormatMessageWithException(String message, Throwable tr) {
		message += System.getProperty("line.separator") + tr.getMessage();
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

		errorWriter.close();
	}	
}
