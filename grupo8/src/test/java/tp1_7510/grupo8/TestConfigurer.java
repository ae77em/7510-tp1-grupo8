package tp1_7510.grupo8;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.TestCase;

public class TestConfigurer 
    extends TestCase{
	
	private Configurator configurator = new Configurator();
		
	public void testCreateConsolesConfigurer(){
		configurator.createPrinter("consoles","console1");
		configurator.createPrinter("consoles","console2");
		
		assertEquals("consoleDefault,console1,console2,", configurator.getConsoles());
	}
	
	public void testCreateFilesConfigurer(){
		configurator.createPrinter("files","file1");
		configurator.createPrinter("files","file2");
		
		assertEquals("file1,file2,", configurator.getFiles());
	}
	
	public void testDefaultSettingsFile(){
		configurator.createPrinter("files","file3");
		
		assertEquals(configurator.getFormatDate("file3"),"%d{HH:mm:ss}");
		assertEquals(configurator.getFormatMessage("file3"),"%d{HH:mm:ss}-%p-%t-%m");
		assertEquals(configurator.getLogLevel("file3"),"DEBUG");
		assertEquals(configurator.getSeparator("file3"),"-");
	}
	
	public void testChangeDefaultSettingsFile(){
		configurator.createPrinter("files","file4");
		
		configurator.setFormatDate("file4","%d{yyyyy-mm-dd hh:mm:ss}");
		configurator.setFormatMessage("file4","%d{HH:mm:ss}-%t-%p-%T-%m");
		configurator.setLogLevel("file4",LogLevel.ERROR);
		configurator.setSeparator("file4","*");
		
		assertEquals(configurator.getFormatDate("file4"),"%d{yyyyy-mm-dd hh:mm:ss}");
		assertEquals(configurator.getFormatMessage("file4"),"%d{HH:mm:ss}-%t-%p-%T-%m");
		assertEquals(configurator.getLogLevel("file4"),"ERROR");
		assertEquals(configurator.getSeparator("file4"),"*");	
	}
	
	public void testGetFileConfiguration(){
		Hashtable<String,String> hashAux = new Hashtable<String,String>();
		hashAux.put("separator","-");
		hashAux.put("format","%d{HH:mm:ss}-%p-%t-%m");
		hashAux.put("name","file5");
		hashAux.put("formatDate","%d{HH:mm:ss}");
		hashAux.put("logLevel","DEBUG");
		
		configurator.createPrinter("files","file5");
			
		assertEquals(configurator.getPrinterConfiguration("file5"),hashAux);		
	}

	
	public void testGetConfigurationPrinters(){
		configurator.createPrinter("files","file5");
		configurator.createPrinter("files","file6");
		configurator.createPrinter("files","file7");
		
		configurator.createPrinter("consoles","console5");
		configurator.createPrinter("consoles","console6");
		configurator.createPrinter("consoles","console7");
		
		Hashtable<String,ArrayList<Hashtable<String, Object>>> printers = new Hashtable<String,ArrayList<Hashtable<String, Object>>>();
		
		printers.put("FILES", configurator.getPrintersConfiguration("files"));
		printers.put("CONSOLES", configurator.getPrintersConfiguration("consoles"));

		assertTrue(true);
	}
	
	public void testLogConsoles(){
		
		configurator.createPrinter("consoles","aConsole");
		configurator.setFormatDate("aConsole", "%d{HH:mm}");
		configurator.setLogLevel("aConsole",LogLevel.INFO);
		configurator.setSeparator("aConsole","*");
		
		Logger logger = new Logger( configurator.getPrintersConfiguration() );			

		assertTrue(logger.logInfo("mensaje1 de prueba"));
		//assertFalse(logger.logError("mensaje2 de prueba"));		
	}

}
