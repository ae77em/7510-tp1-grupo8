package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternThread;

public  class Printer {
	
	protected ArrayList<Pattern> messagePatterns;
	protected FactoryPatterns factoryPatterns;
	LogLevel logLevel;
	
	public Printer(Hashtable<String,String> dataConfiguration){
		
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		messagePatterns = factoryPatterns.createListOfPatterns();
		
		setLogLevel(dataConfiguration.get("logLevel"));
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
	
	private void setLogLevel(String levelString){
				
        switch(levelString){
		 case "OFF": 
			 logLevel = LogLevel.OFF;
		     break;
		 case "FATAL": 
			 logLevel = LogLevel.FATAL;
		     break;
		 case "ERROR": 
			 logLevel = LogLevel.ERROR;
			 break;
		 case "WARN": 
			 logLevel = LogLevel.WARN;
		     break;
		 case "INFO": 
			 logLevel = LogLevel.INFO;
		     break;
		 default: 
			 logLevel = LogLevel.DEBUG;
			 break;
		}
	}

	public void print(String s){
		
	}
	
	public void close(){
		
	}
	
	public Boolean verifyLogLevel(LogLevel level){
		return (level.ordinal() >= logLevel.ordinal());
	}
}
