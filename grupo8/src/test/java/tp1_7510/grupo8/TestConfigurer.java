package tp1_7510.grupo8;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestConfigurer 
    extends TestCase{
	
	private Configurer configurer = new Configurer();
	
	public void testLoadDefaultSettingsConfigurer(){
		String prop = "{consoleDefault-separator=-, consoles=consoleDefault, consoleDefault-formatDate=%d{HH:mm:ss}, consoleDefault-format=%d{HH:mm:ss}-%p-%t-%m, files=, consoleDefault-logLevel=DEBUG}";

		configurer.loadDefaultProperties();

		assertEquals( prop , configurer.getProperties().toString() );		
	}
	
	public void testCreateConsolesConfigurer(){
		configurer.createConsole("console1");
		configurer.createConsole("console2");
		
		assertEquals("console1,console2,", configurer.getConsoles());
	}
	
	public void testCreateFilesConfigurer(){
		configurer.createFile("file1");
		configurer.createFile("file2");
		
		assertEquals("file1,file2,", configurer.getFiles());
	}
	
	public void testDefaultSettingsFile(){
		configurer.createFile("file3");
		
	//	System.out.println(configurer.getFormatMessage("file3"));
		
		assertEquals(configurer.getFormatDate("file3"),"%d{HH:mm:ss}");
		assertEquals(configurer.getFormatMessage("file3"),"%d{HH:mm:ss}-%p-%t-%m");
		assertEquals(configurer.getLogLevel("file3"),"DEBUG");
		assertEquals(configurer.getSeparator("file3"),"-");
	}
	
	public void testChangeDefaultSettingsFile(){
		configurer.createFile("file4");
		
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
		
		configurer.createFile("file5");
			
		assertEquals(configurer.getFileConfiguration("file5"),hashAux);		
	}

	
	public void testGetConfigurationPrinters(){
		configurer.createFile("file5");
		configurer.createFile("file6");
		configurer.createFile("file7");
		
		configurer.createConsole("console5");
		configurer.createConsole("console6");
		configurer.createConsole("console7");
		
		Hashtable<String,ArrayList<Hashtable<String, String>>> printers = new Hashtable<String,ArrayList<Hashtable<String, String>>>();
		
		printers.put("FILES", configurer.getFilesConfiguration());
		printers.put("CONSOLES", configurer.getConsolesConfiguration());

		System.out.println(printers.toString());
	
		assertTrue(true);
	}

}
