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
	private String m_logLevel, m_separator, m_formatDate, m_nameFile;//data necesaria para instanciar los pattenrs
	String[] m_formatMessage; //contiene un vector con el formato del mensaje
	
	public FactoryPatterns(Hashtable<String, String> dataConfiguration){
		m_logLevel = dataConfiguration.get("logLevel");
		m_separator = dataConfiguration.get("separator");
		m_formatDate = dataConfiguration.get("formatDate");
		m_nameFile = dataConfiguration.get("name");
		m_formatMessage = dataConfiguration.get("format").split("-");
	}
	
	public ArrayList<Pattern> createListOfPatterns(){
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		//recorro el vector de patterns y por cada uno creo una instancia
		//de la clase que lo representa
		for(int i=0;i<m_formatMessage.length;i++){
			patterns.add( createPattern(m_formatMessage[i]) );
		}
		
		return patterns;
	}
		
	//-----------------------------------------------
	//fabria de pattenrs
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

}
