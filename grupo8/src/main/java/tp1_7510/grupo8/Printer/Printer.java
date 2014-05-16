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
	private LogLevel m_levelLog;
	private String m_namePrinter;
	
	public Printer(Hashtable<String,String> dataConfiguration){
		
		m_factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		m_messagePatterns = m_factoryPatterns.createListOfPatterns();
		
		setLogLevel(dataConfiguration.get("logLevel"));
		
		m_namePrinter = dataConfiguration.get("name");
	}
	
	public String getPrinterName(){
		return m_namePrinter;
	}
	
	public LogLevel getLogLevel(){
		return m_levelLog;
	}
	
	private void setLogLevel(String levelString){
				
        switch(levelString){
		 case "OFF": 
			 m_levelLog = LogLevel.OFF;
		     break;
		 case "FATAL": 
			 m_levelLog = LogLevel.FATAL;
		     break;
		 case "ERROR": 
			 m_levelLog = LogLevel.ERROR;
			 break;
		 case "WARN": 
			 m_levelLog = LogLevel.WARN;
		     break;
		 case "INFO": 
			 m_levelLog = LogLevel.INFO;
		     break;
		 default: 
			 m_levelLog = LogLevel.DEBUG;
			 break;
		}
	}

	public Boolean verifyLogLevel(LogLevel level){
		return (level.ordinal() <= m_levelLog.ordinal());
	}
	
	public void print(String s){
		
	}
	
	public void close(){
		
	}
	
	
}
