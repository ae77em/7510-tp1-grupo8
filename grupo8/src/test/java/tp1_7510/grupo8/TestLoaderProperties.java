package tp1_7510.grupo8;

import java.util.Hashtable;

import junit.framework.TestCase;

public class TestLoaderProperties extends TestCase {

	String path = "src/main/java/tp1_7510/grupo8/Config/test/config.properties";

	public LoaderPropertiesConfiguration loaderPropertiesConfiguration = new LoaderPropertiesConfiguration(path);
	
	public void testLengthLoggers() {
		assertEquals(2,loaderPropertiesConfiguration.getLenghtLoggers());
	}

	public void testNameLoggers(){
		System.out.println(loaderPropertiesConfiguration.getNameLogger(0));
		assertEquals("filer1",loaderPropertiesConfiguration.getNameLogger(0));
		assertEquals("filer2",loaderPropertiesConfiguration.getNameLogger(1));
	}
	
	public void testTypeLoggers(){
		assertEquals("file",loaderPropertiesConfiguration.getTypeLogger(0));
		assertEquals("file",loaderPropertiesConfiguration.getTypeLogger(1));
	}
	
	public void testFileNameLoggers(){
		assertEquals("aFileName1",loaderPropertiesConfiguration.getFileNameLogger(0));
		assertEquals("aFileName2",loaderPropertiesConfiguration.getFileNameLogger(1));
	}
	
	public void testLevelLoggers(){
		assertEquals("DEBUG",loaderPropertiesConfiguration.getLevelLogLogger(0));
		assertEquals("TRACE",loaderPropertiesConfiguration.getLevelLogLogger(1));
	}
	
	public void testFormatDateLoggers(){
		assertEquals("dd-M-yyyy hh:mm:ss",loaderPropertiesConfiguration.getFormatDateLogger(0));
		assertEquals("yyyy MMM dd",loaderPropertiesConfiguration.getFormatDateLogger(1));
	}
	
	public void testPatternMessageLoggers(){
		assertEquals("%d%s%l%s",loaderPropertiesConfiguration.getPatternMessageLogger(0));
		assertEquals("%d%s%l%s%m",loaderPropertiesConfiguration.getPatternMessageLogger(1));
	}
	
	public void testSeparatorLoggers(){
		assertEquals("-",loaderPropertiesConfiguration.getSeparatorLogger(0));
		assertEquals("*",loaderPropertiesConfiguration.getSeparatorLogger(1));
	}
	
	public void testRegularExpresionLoggers(){
		assertEquals("^[a-zA-Z0-9]*$",loaderPropertiesConfiguration.getRegularExpresionLogger(0));
		assertEquals("^[a-z0-9]*$",loaderPropertiesConfiguration.getRegularExpresionLogger(1));
	}
	
	public void testCustomFilterLoggers(){
		Hashtable<String, String> hashCustomsFilters = new Hashtable<String, String>();
		
		hashCustomsFilters.put("%d","filter%d");
		hashCustomsFilters.put("%s","filter%s");
		hashCustomsFilters.put("%l","filter%l");
		hashCustomsFilters.put("%T","filter%T");

		assertEquals(hashCustomsFilters,loaderPropertiesConfiguration.getCustomFilterLogger(0));
	}
}
