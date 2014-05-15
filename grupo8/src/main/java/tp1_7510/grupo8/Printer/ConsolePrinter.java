package tp1_7510.grupo8.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

public class ConsolePrinter implements Printer {
	public static String message = "";

	private PrintWriter m_Writter;
	private String m_logLevel, m_separator, m_formatDate, m_nameFile;
	private ArrayList<Pattern> messagePatterns;

	public ConsolePrinter(Hashtable<String, String> dataConfiguration){
		m_logLevel = dataConfiguration.get("logLevel");
		m_separator = dataConfiguration.get("separator");
		m_formatDate = dataConfiguration.get("formatDate");
		m_nameFile = dataConfiguration.get("name");
						
		messagePatterns = createListOfPatterns(dataConfiguration.get("format").split("-"));
	}
	
	private ArrayList<Pattern> createListOfPatterns(String[] patternsText){
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		
		for(int i=0;i<patternsText.length;i++){
			patterns.add( createPattern(patternsText[i]) );
		}
		
		return patterns;
	}
		
	//-----------------------------------------------
	private Pattern createPattern(String aPattern) {	
		Pattern patternCreated = null;
		
		switch(aPattern.substring(0,2)){
		
			 case "%d": //buscar con expresion regular por %d
			     patternCreated = new PatternDate(aPattern.substring(3,aPattern.length()-1));
			     break;
			 case "%p": 
				 patternCreated = new PatternLevel(m_logLevel);
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
				 patternCreated = new PatternSeparator(m_separator);
			     break;
			     
			 case "%L": 
				 patternCreated = new PatternLineNumber();
			     break;
			     
			 case "%F": 
				 patternCreated = new PatternFilename(m_nameFile);
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
	
	public void print(String aMessage){
		message = aMessage;
		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.formatText(messageFormated);
			System.out.println(messageFormated);
		}
		
		System.out.println(messageFormated);
	}

	public void close() {

	}
}
