package tp1_7510.grupo8.Patterns;

import java.util.ArrayList;
import java.util.Properties;

public class MessagePattern {
	
	private Properties properties;
	private ArrayList<MessagePattern> message;
	
	MessagePattern(String[] patternsText){
		this.message=createListOfPatterns(patternsText);	
	}
	
	MessagePattern(Properties p){
		this.properties=p;
		getPatternsFromProperties();
	}
	
	//-----------------------------------------------
	private ArrayList<MessagePattern> createListOfPatterns(String[] patternsText){
		
		ArrayList<MessagePattern> patterns = new ArrayList<MessagePattern>();
		
		for(int i=0;i<patternsText.length;i++){			
			patterns.add( (MessagePattern) createPattern(patternsText[i]) );
		}
		
		return patterns;
	}
	
	//-----------------------------------------------
	public ArrayList<MessagePattern> getPatternsFromProperties(){
		
		String[] patternsText = properties.getProperty("format").split("-");

		return createListOfPatterns(patternsText);
	}
	
	//-----------------------------------------------
	public ArrayList<MessagePattern> getPatterns(){
		
		String[] patternsText = properties.getProperty("format").split("-");

		return createListOfPatterns(patternsText);
	}

	
	//-----------------------------------------------
	private Object createPattern(String aPattern) {
		
		Object patternCreated = null;
		
		switch(aPattern.substring(0,1)){
			 case "%d": //buscar con expresion regular por %d
			     patternCreated = new PatternDate();
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
}
