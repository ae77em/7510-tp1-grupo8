package tp1_7510.grupo8;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
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
		assertEquals(configurer.getLogLevel1("file3"),"DEBUG");
		assertEquals(configurer.getSeparator("file3"),"-");
	}
	
	public void testChangeDefaultSettingsFile(){
		configurer.createFile("file3");
		
		configurer.setFormatDate("file3","%d{yyyyy-mm-dd hh:mm:ss}");
		configurer.setFormatMessage("file3","%d{HH:mm:ss}-%t-%p-%T-%m");
		configurer.setLogLevel("file3","ERROR");
		configurer.setSeparator("file3","*");
		
		assertEquals(configurer.getFormatDate("file3"),"%d{yyyyy-mm-dd hh:mm:ss}");
		assertEquals(configurer.getFormatMessage("file3"),"%d{HH:mm:ss}-%t-%p-%T-%m");
		assertEquals(configurer.getLogLevel1("file3"),"ERROR");
		assertEquals(configurer.getSeparator("file3"),"*");
		
	}
}
