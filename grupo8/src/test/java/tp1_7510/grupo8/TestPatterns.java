package tp1_7510.grupo8;

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
import junit.framework.TestCase;

import java.text.*;
import java.util.Date;



public class TestPatterns extends TestCase {
		
	public void testPatternDate(){
		PatternDate patternDate	= new PatternDate();
		String prueba = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		
		assertEquals(prueba.toString(), patternDate.addText(""));
	
	}
	
	public void testPatternEscape(){
		PatternEscape patternEscape	= new PatternEscape();
		
	}
	
	public void testPatternFilenamee(){
		PatternFilename patternFilename	= new PatternFilename("unArchivo.txt");
	}
	
	public void testPatternLevel(){
		PatternLevel patternLevel = new PatternLevel();
	}
	
	public void testPatternLineNumber(){
		PatternLineNumber patternLineNumber = new PatternLineNumber();
	}
	
	public void testPatternMethodName(){
		PatternMethodName patternMethodName	= new PatternMethodName();
	}
	
	public void testPatternSeparator(){
		PatternSeparator patternSeparator = new PatternSeparator();
	}
	
	public void testPatternSimpleMessage(){
		PatternSimpleMessage patternSimpleMessage = new PatternSimpleMessage("Hola");
	}
	
	public void testPatternThread(){
		PatternThread patternThread = new PatternThread();
	}
	
	public void testPatternUserDefinedMessage(){
		PatternUserDefinedMessage patternUserDefinedMessage = new PatternUserDefinedMessage();
	}

}
