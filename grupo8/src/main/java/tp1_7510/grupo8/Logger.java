package tp1_7510.grupo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.Exception;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternEscape;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternLineNumber;
import tp1_7510.grupo8.Patterns.PatternMethodName;
import tp1_7510.grupo8.Patterns.PatternPrinterName;
import tp1_7510.grupo8.Patterns.PatternSeparator;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;
import tp1_7510.grupo8.Patterns.PatternThread;
import tp1_7510.grupo8.Patterns.PatternUserDefinedMessage;
import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.JsonPrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	PrintWriter errorWriter;
	
	public static String message = "", level = "";
	
	private Printer printer;
	
	Logger(JSONObject jsonConfig){
		
		generatePrinter(jsonConfig);
		
		try {
			errorWriter = new PrintWriter( new File ("error.dat" ) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
		     printer = new ConsolePrinter(configPatter,filterCustom);
		     break;
		 case "CONSOLES":					
			 try {
				printer = new FilePrinter(configPatter,filterCustom);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     break;
		 case "JSON": //????????????? NI DEA SI QUEDA 
			 try {
				printer = new JsonPrinter(configPatter,filterCustom);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
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
			System.out.println("ESTA TODO MAL"+printer.getErrorMessage());

        	errorWriter.println(printer.getErrorMessage());
    	}
	}
	
	public void logOff(String message){
		log(message,LogLevel.OFF);
	}
	
	public void logFatal(String message){
		log(message,LogLevel.FATAL);
	}
	
	public void logError(String message){
		log(message,LogLevel.ERROR);
	}
	
	public void logWarn(String message){
		log(message,LogLevel.WARN);
	}
	
	public void logInfo(String message){
		log(message,LogLevel.INFO);
	}
	
	public void logDebug(String message){
		log(message,LogLevel.DEBUG);
	}
	
	public void logTrace(String message){
		log(message,LogLevel.TRACE);
	}	
	
	public void logOff(String message, Exception ex){
		try {
			log(message,LogLevel.OFF);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void logFatal(String message, Exception ex){
		try {
			log(message,LogLevel.FATAL);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logError(String message, Exception ex){
		try {
			log(message,LogLevel.ERROR);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logWarn(String message, Exception ex){
		try {
			log(message,LogLevel.WARN);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logInfo(String message, Exception ex){
		try {
			log(message,LogLevel.INFO);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logDebug(String message, Exception ex){
		try {
			log(message,LogLevel.DEBUG);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logTrace(String message, Exception ex){
		try {
			log(message,LogLevel.TRACE);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}

	public void close() {
		printer.close();

		errorWriter.close();
	}	
}
