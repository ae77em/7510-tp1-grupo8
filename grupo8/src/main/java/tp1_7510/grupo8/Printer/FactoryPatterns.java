package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternEscape;
import tp1_7510.grupo8.Patterns.PatternFilename;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternLineNumber;
import tp1_7510.grupo8.Patterns.PatternMethodName;
import tp1_7510.grupo8.Patterns.PatternSeparator;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;
import tp1_7510.grupo8.Patterns.PatternThread;
import tp1_7510.grupo8.Patterns.PatternUserDefinedMessage;

public class FactoryPatterns {
	private LogLevel logLevel;
	private String separator; 
	@SuppressWarnings("unused")
	private String formatDate; 
	private String nameFile;
	private String[] formatMessage; 
	
	public FactoryPatterns(Hashtable<String, String> dataConfiguration){
		setLogLevel(LogLevel.valueOf((String) dataConfiguration.get("logLevel")));
		separator = (String) dataConfiguration.get("separator");
		formatDate = (String) dataConfiguration.get("formatDate");
		nameFile = (String) dataConfiguration.get("name");
		formatMessage = ((String) dataConfiguration.get("format")).split("-");
	}
	
	public void setLogLevel(LogLevel ll){
		this.logLevel = ll;
	}
	
	public ArrayList<Pattern> createListOfPatterns(){
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();

		for( String fm : formatMessage ){
			patterns.add( createPattern(fm) );
		}
		
		return patterns;
	}
		
	private Pattern createPattern(String aPattern) {	
		Pattern patternCreated = null;
		
		switch(aPattern.substring(0,2)){
			 case "%d":
			     patternCreated = new PatternDate(aPattern.substring(3,aPattern.length()-1));
			     break;
			 case "%p": 
				 patternCreated = new PatternLevel(logLevel);
			     break;
			 case "%t": 
				 patternCreated = new PatternThread();
				 break;
			 case "%m": 
				 patternCreated = new PatternUserDefinedMessage();
			     break;
			 case "%%": 
				 patternCreated = new PatternEscape();
			     break;			     
			 case "%n": 
				 patternCreated = new PatternSeparator(separator);
			     break;			     
			 case "%L": 
				 patternCreated = new PatternLineNumber();
			     break;			     
			 case "%F": 
				 patternCreated = new PatternFilename(nameFile);
			     break;
			 case "%M": 
				 patternCreated = new PatternMethodName();
				 break;
			 default:
					patternCreated = new PatternSimpleMessage(aPattern);
	                break;
			}
		
		return patternCreated;
	}

}
