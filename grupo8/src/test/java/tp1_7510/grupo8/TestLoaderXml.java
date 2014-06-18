package tp1_7510.grupo8;

import java.util.Hashtable;

import junit.framework.TestCase;


public class TestLoaderXml extends TestCase{
	String path = "src/test/java/tp1_7510/grupo8/testOutputFiles/testConfig/config.xml";
	
	public LoaderXmlConfiguration loaderXmlConfiguration = new LoaderXmlConfiguration(path);
	
	public void testLengthLoggers() {
		assertEquals(2,loaderXmlConfiguration.getLenghtLoggers());
	}

	public void testNameLoggers(){
		assertEquals("LogParser",loaderXmlConfiguration.getNameLogger(0));
	}
	
	public void testTypeLoggers(){
		assertEquals("CONSOLES",loaderXmlConfiguration.getTypeLogger(0));
	}
	
	public void testFileNameLoggers(){
		assertEquals("parserLog",loaderXmlConfiguration.getFileNameLogger(0));
	}
	
	public void testLevelLoggers(){
		assertEquals("DEBUG",loaderXmlConfiguration.getLevelLogLogger(0));
	}
	
	public void testFormatDateLoggers(){
		assertEquals("dd-M-yyyy hh:mm:ss",loaderXmlConfiguration.getFormatDateLogger(0));
	}
	
	public void testPatternMessageLoggers(){
		assertEquals("%L-%n-%d-%n-%g-%n-%p-%n-%m",loaderXmlConfiguration.getPatternMessageLogger(0));
	}
	
	public void testSeparatorLoggers(){
		assertEquals("-",loaderXmlConfiguration.getSeparatorLogger(0));
	}
	
	public void testRegularExpresionLoggers(){
		assertEquals("^[a-zA-Z0-9]*$",loaderXmlConfiguration.getRegularExpresionLogger(0));
	}
	
	public void testCustomFilterLoggers(){
		Hashtable<String, String> hashCustomsFilters = new Hashtable<String, String>();
		
		hashCustomsFilters.put("%L","^\\d+$");
		hashCustomsFilters.put("%g","LogParser");
		hashCustomsFilters.put("%m","^*patter14");
		
		assertEquals(hashCustomsFilters,loaderXmlConfiguration.getCustomFilterLogger(0));
	}
}
