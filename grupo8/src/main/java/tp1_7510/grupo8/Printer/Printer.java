package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;

public abstract class Printer {
	
	protected ArrayList<Pattern> messagePatterns;
	protected FactoryPatterns factoryPatterns;
	LogLevel logLevel;
	
	public Printer(Hashtable<String, String> dataConfiguration){
		
		factoryPatterns = new FactoryPatterns(dataConfiguration);		
		messagePatterns = factoryPatterns.createListOfPatterns();
		
		setLogLevel(LogLevel.valueOf((String) dataConfiguration.get("logLevel")));
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
	
	private void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
	}

	public abstract void print(String s);
}
