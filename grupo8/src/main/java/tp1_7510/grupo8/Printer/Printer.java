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
	
	public Printer(Hashtable<String, Object> dataConfiguration){
		
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		messagePatterns = factoryPatterns.createListOfPatterns();
		
		setLogLevel((LogLevel)dataConfiguration.get("logLevel"));
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
	
	private void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
	}

	public void print(String s){
		
	}
	
	public void close(){
		
	}
	

}
