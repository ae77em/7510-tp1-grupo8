package tp1_7510.grupo8.Printer;

import java.io.*;
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
import tp1_7510.grupo8.Patterns.PatternThread;
import tp1_7510.grupo8.Patterns.PatternUserDefinedMessage;

public class FilePrinter implements Printer 
{
	private PrintWriter m_Writter;
	private String m_logLevel;
	private String m_separator;
	private String m_formatDate;
	//private String m_formatMessage;
	
	private ArrayList<Pattern> messagePatterns;
	
	public FilePrinter(Hashtable<String,String> dataConfiguration) throws FileNotFoundException{
		m_logLevel = dataConfiguration.get("logLevel");
		m_separator = dataConfiguration.get("separator");
		m_formatDate = dataConfiguration.get("formatDate");
		//m_formatMessage = dataConfiguration.get("format");
		
		String nameFile = dataConfiguration.get("name");
		
		m_Writter = new PrintWriter(new FileOutputStream(new File(nameFile),true));
		messagePatterns = createListOfPatterns(dataConfiguration.get("format").split("-"));
	}
	
	private ArrayList<Pattern> createListOfPatterns(String[] patternsText){
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		
		for(int i=0;i<patternsText.length;i++){
			System.out.println("CREE "+patternsText[i]);
			patterns.add( createPattern(patternsText[i]) );
		}
		
		return patterns;
	}
		
	//-----------------------------------------------
	private Pattern createPattern(String aPattern) {	
		Pattern patternCreated = null;
		
		switch(aPattern.substring(0,2)){
		
			 case "%d": //buscar con expresion regular por %d
			     patternCreated = new PatternDate(aPattern.substring(2));
			     break;
			 case "%p": 
				 patternCreated = new PatternLevel();
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
				 patternCreated = new PatternSeparator();
			     break;
			     
			 case "%L": 
				 patternCreated = new PatternLineNumber();
			     break;
			     
			 case "%F": 
				 patternCreated = new PatternFilename();
			     break;
			     
			 case "%M": 
				 patternCreated = new PatternMethodName();
				 break;
			}
		
		return patternCreated;
	}
	
	public void print(String message){
		m_Writter.println(message);
	}

	public String notifyDestiny(String s) {
		return s;
	}
}
