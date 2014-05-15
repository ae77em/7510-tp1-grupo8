package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternThread;

//interface que usan las clases que imprimen los mensajes de log
public  class Printer {
	protected ArrayList<Pattern> m_messagePatterns;//contendra los patrones a aplicar al mensaje
	protected FactoryPatterns m_factoryPatterns;//fabrica los patrones a aplicar al mensaje
	LogLevel m_levelLog;
	
	public Printer(Hashtable<String,String> dataConfiguration){
		m_factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		m_messagePatterns = m_factoryPatterns.createListOfPatterns();
		
		m_levelLog = setLogLevel(dataConfiguration.get("logLevel"));
	}
	
	private LogLevel setLogLevel(String levelString){
		LogLevel level;
		
        switch(levelString){
		 case "OFF": 
		     level = LogLevel.OFF;
		     break;
		 case "FATAL": 
			 level = LogLevel.FATAL;
		     break;
		 case "ERROR": 
			 level = LogLevel.ERROR;
			 break;
		 case "WARN": 
			 level = LogLevel.WARN;
		     break;
		 case "INFO": 
			 level = LogLevel.INFO;
		     break;
		 default: 
			 level = LogLevel.DEBUG;
			 break;
		}
        return level;
	}

	public void print(String s){
		
	}
	
	public void close(){
		
	}
	
	public Boolean verifyLogLevel(LogLevel level){
		return (level.ordinal() >= m_levelLog.ordinal());
	}
}
