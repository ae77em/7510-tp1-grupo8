package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import tp1_7510.grupo8.Patterns.*;

public class Configurer {
	
	private Properties prop;
	
	Configurer(){
		prop = new Properties();
		loadProperties();
	}

	private void loadProperties(){
		
		InputStream input = null;
	 
		try {
			input = new FileInputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");	 
			// load a properties file
			prop.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
	}
	
	public ArrayList<MessagePattern> getPatternsOfList(String[] patternsText){
		ArrayList<MessagePattern> patterns = new ArrayList<MessagePattern>();
		for(int i=0;i<patternsText.length;i++){
			patterns.add( createPattern(patternsText[i]) );
		}
		
		return patterns;
	}
	
	public ArrayList<MessagePattern> getPatterns(){
		String[] patternsText = prop.getProperty("format").split("-");

		return getPatternsOfList(patternsText);
	}
	
	private MessagePattern createPattern(String aPattern) {
		MessagePattern patternCreated = null;
		
		switch(aPattern){
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
