package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.ControllerCustom;
import tp1_7510.grupo8.FilterCustom;
import tp1_7510.grupo8.CONSTANTS.LogLevel;
import tp1_7510.grupo8.Patterns.*;

public class FactoryPatterns {
	private LogLevel logLevel;
	private String separator; 
	private String namePrinter;
	private String formatDate; 
	private String nameFile;
	private String[] formatMessage;
	
	ArrayList<Pattern> patterns;
	ControllerCustom controllerFilterCustom;
	
	Hashtable<String, String> filtersCustom;
	
	public FactoryPatterns(Hashtable<String, String> dataConfiguration, Hashtable<String, String> aFiltersCustom){
		filtersCustom = aFiltersCustom;
		
		String logLevel = (String) dataConfiguration.get("logLevel"); 
		setLogLevel(LogLevel.valueOf(logLevel));
		separator = (String) dataConfiguration.get("separator");
		formatDate = (String) dataConfiguration.get("formatDate");
		nameFile = (String) dataConfiguration.get("name");
		formatMessage = ((String) dataConfiguration.get("format")).split("-");
		namePrinter = (String) dataConfiguration.get("namePrinter");
		
		patterns = new ArrayList<Pattern>();
		controllerFilterCustom = new ControllerCustom();
	}
	
	public void setLogLevel(LogLevel logLevel){
		this.logLevel = logLevel;
	}
	
	/*
	 * se encarga se crear los disintos patterns a aplicar el logger sobre un mensaje
	 * y ademas los carga en un hash junto con su ID (%g,%T, etc) para luego, en la parte de validacion de mensajes
	 * tomar desde ahi el String devuleto por el pattern aplicado y evaluarlo con el filter custom definido sobre dicho pattern 
	 */
	public void buildPatterns(){
		for( String aFormatMessage : formatMessage ){
			Pattern aPattern = createPattern(aFormatMessage);
			
			patterns.add( aPattern );
			
			if(filtersCustom.get(aFormatMessage) != null){
				controllerFilterCustom.addFilterCustom(new FilterCustom(filtersCustom.get(aFormatMessage),aPattern));		
			}
		}
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

	public ControllerCustom getFilterCustomOfPatterns() {
		return controllerFilterCustom;
	}

}
