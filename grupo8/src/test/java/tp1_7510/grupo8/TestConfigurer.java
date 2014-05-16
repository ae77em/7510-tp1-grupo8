package tp1_7510.grupo8;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestConfigurer 
    extends TestCase{
	
	private Configurer configurer = new Configurer();
		
	public void testCreateConsolesConfigurer(){
		configurer.createPrinter("consoles","console1");
		configurer.createPrinter("consoles","console2");
		
		assertEquals("consoleDefault,console1,console2,", configurer.getConsoles());
	}
	
	public void testCreateFilesConfigurer(){
		configurer.createPrinter("files","file1");
		configurer.createPrinter("files","file2");
		
		assertEquals("file1,file2,", configurer.getFiles());
	}
	
	public void testDefaultSettingsFile(){
		configurer.createPrinter("files","file3");
		
		assertEquals(configurer.getFormatDate("file3"),"%d{HH:mm:ss}");
		assertEquals(configurer.getFormatMessage("file3"),"%d{HH:mm:ss}-%p-%t-%m");
		assertEquals(configurer.getLogLevel("file3"),"DEBUG");
		assertEquals(configurer.getSeparator("file3"),"-");
	}
	
	public void testChangeDefaultSettingsFile(){
		configurer.createPrinter("files","file4");
		
		configurer.setFormatDate("file4","%d{yyyyy-mm-dd hh:mm:ss}");
		configurer.setFormatMessage("file4","%d{HH:mm:ss}-%t-%p-%T-%m");
		configurer.setLogLevel("file4","ERROR");
		configurer.setSeparator("file4","*");
		
		assertEquals(configurer.getFormatDate("file4"),"%d{yyyyy-mm-dd hh:mm:ss}");
		assertEquals(configurer.getFormatMessage("file4"),"%d{HH:mm:ss}-%t-%p-%T-%m");
		assertEquals(configurer.getLogLevel("file4"),"ERROR");
		assertEquals(configurer.getSeparator("file4"),"*");	
	}
	
	public void testGetFileConfiguration(){
		Hashtable<String,String> hashAux = new Hashtable<String,String>();
		hashAux.put("separator","-");
		hashAux.put("format","%d{HH:mm:ss}-%p-%t-%m");
		hashAux.put("name","file5");
		hashAux.put("formatDate","%d{HH:mm:ss}");
		hashAux.put("logLevel","DEBUG");
		
		configurer.createPrinter("files","file5");
			
		assertEquals(configurer.getPrinterConfiguration("file5"),hashAux);		
	}

	
	public void testGetConfigurationPrinters(){
		configurer.createPrinter("files","file5");
		configurer.createPrinter("files","file6");
		configurer.createPrinter("files","file7");
		
		configurer.createPrinter("consoles","console5");
		configurer.createPrinter("consoles","console6");
		configurer.createPrinter("consoles","console7");
		
		Hashtable<String,ArrayList<Hashtable<String, String>>> printers = new Hashtable<String,ArrayList<Hashtable<String, String>>>();
		
		printers.put("FILES", configurer.getPrintersConfiguration("files"));
		printers.put("CONSOLES", configurer.getPrintersConfiguration("consoles"));

		assertTrue(true);
	}
	
	public void testLogConsoles(){
		
		configurer.createPrinter("consoles","aConsole");
		configurer.setFormatDate("aConsole", "%d{HH:mm}");
		configurer.setLogLevel("aConsole","INFO");
		configurer.setSeparator("aConsole","*");
		
		Logger logger = new Logger( configurer.getPrintersConfiguration() );			

		assertTrue(logger.log("mensaje1 de prueba",LogLevel.INFO));
		assertFalse(logger.log("mensaje2 de prueba",LogLevel.ERROR));		
	}

}
