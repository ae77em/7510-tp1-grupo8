package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

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
	private String logLevel;
	private String separator; 
	private String formatDate; 
	private String nameFile;
	private String[] formatMessage; 
	
	public FactoryPatterns(Hashtable<String, String> dataConfiguration){
		logLevel = dataConfiguration.get("logLevel");
		separator = dataConfiguration.get("separator");
		formatDate = dataConfiguration.get("formatDate");
		nameFile = dataConfiguration.get("name");
		formatMessage = dataConfiguration.get("format").split("-");
	}
	
	public ArrayList<Pattern> createListOfPatterns(){
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		//recorro el vector de patterns y por cada uno creo una instancia
		//de la clase que lo representa
		for( String fm : formatMessage ){
			patterns.add( createPattern(fm) );
		}
		
		return patterns;
	}
		
	//-----------------------------------------------
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
