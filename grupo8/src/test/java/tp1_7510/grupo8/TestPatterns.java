package tp1_7510.grupo8;

import tp1_7510.grupo8.CONSTANTS.LogLevel;
import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Logger.Logger;
import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternEscape;
import tp1_7510.grupo8.Patterns.PatternPrinterName;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternLineNumber;
import tp1_7510.grupo8.Patterns.PatternMethodName;
import tp1_7510.grupo8.Patterns.PatternSeparator;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;
import tp1_7510.grupo8.Patterns.PatternThread;
import tp1_7510.grupo8.Patterns.PatternUserDefinedMessage;
import tp1_7510.loadersConfigurations.Configurator;
import junit.framework.TestCase;

import java.text.*;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestPatterns extends TestCase {
	
	Configurator configurator = new Configurator(PathLogs.PATH_TEST+"testConfig/config.properties");
	
	JSONArray configLoggers = configurator.getConfigurationLogger();
	
	Logger aLogger = new Logger((JSONObject)configLoggers.get(0));
		
	public void testPatternDate(){
		
		PatternDate patternDate	= new PatternDate();
		PatternDate patternDateUD	= new PatternDate("10/10/2013");
		String prueba = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		
		assertEquals(prueba.toString(), patternDate.getText());	
		assertEquals("10/10/2013", patternDateUD.getText());
	}
	
	public void testPatternEscape(){
		
		PatternEscape patternEscape	= new PatternEscape();
				
		assertEquals("%", patternEscape.addText(""));
		assertEquals("%%", patternEscape.addText("%"));
	}
	
	public void testPatternFilenamee(){
		
		PatternPrinterName patternFilename	= new PatternPrinterName("unArchivo.txt");
		
		assertEquals("unArchivo.txt", patternFilename.addText(""));
		assertEquals("aaaunArchivo.txt", patternFilename.addText("aaa"));
	}
	
	public void testPatternLineNumber(){
		
		PatternLineNumber patternLineNumber = new PatternLineNumber();
		
		assertEquals("linea 0", patternLineNumber.addText("linea "));
		assertEquals("linea 1", patternLineNumber.addText("linea "));
		assertEquals("linea 2", patternLineNumber.addText("linea "));		
	}
	
	public void testPatternMethodName(){
		
		PatternMethodName patternMethodName	= new PatternMethodName();
		
		assertEquals("getText", patternMethodName.getText());		
	}
	
	public void testPatternSeparator(){
		
		PatternSeparator patternSeparator = new PatternSeparator();
		PatternSeparator patternSeparatorUD = new PatternSeparator("??");
		
		assertEquals("-", patternSeparator.getText());
		assertEquals("??", patternSeparatorUD.getText());
		assertEquals("=-", patternSeparator.addText("="));
		assertEquals("AAA??", patternSeparatorUD.addText("AAA"));
	}
	
	public void testPatternSimpleMessage(){
		
		PatternSimpleMessage patternSimpleMessage = new PatternSimpleMessage("Hola");
		PatternSimpleMessage patternSimpleMessageUD = new PatternSimpleMessage();
		
		assertEquals("Hola", patternSimpleMessage.getText());
		assertEquals("", patternSimpleMessageUD.getText());
	}
	
	public void testPatternThread(){
		
		PatternThread patternThread = new PatternThread();
		
		assertEquals("main", patternThread.getText());
		assertEquals("AAAAmain", patternThread.addText("AAAA"));
	}
	
	public void testPatternUserDefinedMessage(){
		PatternUserDefinedMessage patternUserDefinedMessage = new PatternUserDefinedMessage();
		
		aLogger.debug("MensajeLogueado");
		
		assertEquals("TrasfRealizada-MensajeLogueado", patternUserDefinedMessage.addText("TrasfRealizada-"));
	}
	
	public void testPatternNamePrinter(){
		PatternPrinterName patternPrinterName = new PatternPrinterName("filer1");
		
		aLogger.debug("MensajeLoguead");
		
		assertEquals("filer1", patternPrinterName.addText(""));
	}

}
