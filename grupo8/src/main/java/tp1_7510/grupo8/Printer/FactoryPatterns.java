package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.Logger.LogLevel;
import tp1_7510.grupo8.Patterns.*;

public class FactoryPatterns {
	private LogLevel logLevel;
	private String separator; 
	private String namePrinter;
	private String formatDate; 
	private String nameFile;
	private String[] formatMessage;
	
	ArrayList<Pattern> patterns;
	Hashtable<String, Pattern> filterCustom;
	
	public FactoryPatterns(Hashtable<String, String> dataConfiguration){
		setLogLevel(LogLevel.valueOf((String) dataConfiguration.get("logLevel")));
		separator = (String) dataConfiguration.get("separator");
		formatDate = (String) dataConfiguration.get("formatDate");
		nameFile = (String) dataConfiguration.get("name");
		formatMessage = ((String) dataConfiguration.get("format")).split("-");
		namePrinter = (String) dataConfiguration.get("namePrinter");
		
		patterns = new ArrayList<Pattern>();
		filterCustom = new Hashtable<String,Pattern>();
	}
	
	public void setLogLevel(LogLevel ll){
		this.logLevel = ll;
	}
	
	/*
	 * se encarga se crear los disintos patterns a aplicar el logger sobre un mensaje
	 * y ademas los carga en un hash junto con su ID (%g,%T, etc) para luego, en la parte de validacion de mensajes
	 * tomar desde ahi el String devuleto por el pattern aplicado y evaluarlo con el filter custom definido sobre dicho pattern 
	 */
	public ArrayList<Pattern> buildPatterns(){
		for( String fm : formatMessage ){
			Pattern aPattern = createPattern(fm);
			
			patterns.add( aPattern );
			
			filterCustom.put(fm,aPattern);	
		}
		
		return patterns;
	}
		
	private Pattern createPattern(String aPattern) {	
		Pattern patternCreated = null;

		switch(aPattern){
			 case "%g":					
			     patternCreated = new PatternPrinterName(namePrinter);
			     break;
			 case "%d":					
			     patternCreated = new PatternDate(formatDate.substring(1,formatDate.length()-1));
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
				 patternCreated = new PatternPrinterName(nameFile);
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

	public ArrayList<Pattern> getListOfPatterns() {
		return patterns;
	}

	public Hashtable<String, Pattern> getFilterCustomOfPatterns() {
		return filterCustom;
	}

}
