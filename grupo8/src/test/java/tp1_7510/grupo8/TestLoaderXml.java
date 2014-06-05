package tp1_7510.grupo8;

import static org.junit.Assert.*;
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
		String customPattern1 = "{%T=ALGO, %s=ALGO, %d=ALGO, %l=ALGO}";
		String customPattern2 = "{%T=ALGO, %g=ALGO, %L=ALGO, %l=ALGO}";

		assertEquals(customPattern1,loaderXmlConfiguration.getCustomFilterLogger(0).toString());
		assertEquals(customPattern2,loaderXmlConfiguration.getCustomFilterLogger(1).toString());
	}
}
