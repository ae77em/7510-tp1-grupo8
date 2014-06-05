package tp1_7510.grupo8;

import static org.junit.Assert.*;

import java.util.Hashtable;

import junit.framework.TestCase;

import org.junit.Test;

public class TestLoaderXml extends TestCase{
	String path = "src/main/java/tp1_7510/grupo8/Config/config.xml";

	public LoaderXmlConfiguration loaderXmlConfiguration = new LoaderXmlConfiguration(path);
	
	public void testLengthLoggers() {
		assertEquals(2,loaderXmlConfiguration.getLenghtLoggers());
	}

	public void testNameLoggers(){
		assertEquals("LogParser",loaderXmlConfiguration.getNameLogger(0));
		assertEquals("LogIndexer",loaderXmlConfiguration.getNameLogger(1));
	}
	
	public void testTypeLoggers(){
		assertEquals("FILES",loaderXmlConfiguration.getTypeLogger(0));
		assertEquals("CONSOLES",loaderXmlConfiguration.getTypeLogger(1));
	}
	
	public void testFileNameLoggers(){
		assertEquals("parserLog",loaderXmlConfiguration.getFileNameLogger(0));
		assertEquals("indexerLog",loaderXmlConfiguration.getFileNameLogger(1));
	}
	
	public void testLevelLoggers(){
		assertEquals("DEBUG",loaderXmlConfiguration.getLevelLogLogger(0));
		assertEquals("ERROR",loaderXmlConfiguration.getLevelLogLogger(1));
	}
	
	public void testFormatDateLoggers(){
		assertEquals("dd-M-yyyy hh:mm:ss",loaderXmlConfiguration.getFormatDateLogger(0));
		assertEquals("yyyy MMM dd",loaderXmlConfiguration.getFormatDateLogger(1));
	}
	
	public void testPatternMessageLoggers(){
		assertEquals("%d%s%l%s",loaderXmlConfiguration.getPatternMessageLogger(0));
		assertEquals("%L%s%d%s%l%s",loaderXmlConfiguration.getPatternMessageLogger(1));
	}
	
	public void testSeparatorLoggers(){
		assertEquals("-",loaderXmlConfiguration.getSeparatorLogger(0));
		assertEquals("*",loaderXmlConfiguration.getSeparatorLogger(1));
	}
	
	public void testRegularExpresionLoggers(){
		assertEquals("Expresion1",loaderXmlConfiguration.getRegularExpresionLogger(0));
		assertEquals("Expresion2",loaderXmlConfiguration.getRegularExpresionLogger(1));
	}
	
	public void testCustomFilterLoggers(){
		Hashtable<String, String> hashCustomsFilters = new Hashtable<String, String>();
		
		hashCustomsFilters.put("%d","patter1.1");
		hashCustomsFilters.put("%s","patter1.2");
		hashCustomsFilters.put("%l","patter1.3");
		hashCustomsFilters.put("%T","patter1.4");

		assertEquals(hashCustomsFilters,loaderXmlConfiguration.getCustomFilterLogger(0));
	}
}
