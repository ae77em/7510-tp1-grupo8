package tp1_7510.grupo8;

import java.util.Hashtable;

import junit.framework.TestCase;

public class TestLoaderProperties extends TestCase {

	String path = "src/test/java/tp1_7510/grupo8/testOutputFiles/testConfig/config.properties";

	public LoaderPropertiesConfiguration loaderPropertiesConfiguration = new LoaderPropertiesConfiguration(path);
	
	public void testLengthLoggers() {
		assertEquals(1,loaderPropertiesConfiguration.getLenghtLoggers());
	}

	public void testNameLoggers(){
		assertEquals("filer1",loaderPropertiesConfiguration.getNameLogger(0));
	}
	
	public void testTypeLoggers(){
		assertEquals("FILES",loaderPropertiesConfiguration.getTypeLogger(0));
	}
	
	public void testFileNameLoggers(){
		assertEquals("aFileName1",loaderPropertiesConfiguration.getFileNameLogger(0));
	}
	
	public void testLevelLoggers(){
		assertEquals("DEBUG",loaderPropertiesConfiguration.getLevelLogLogger(0));
	}
	
	public void testFormatDateLoggers(){
		assertEquals("dd-M-yyyy hh:mm:ss",loaderPropertiesConfiguration.getFormatDateLogger(0));
	}
	
	public void testPatternMessageLoggers(){
		assertEquals("%d-%n-%p-%n-%t-%n-%m",loaderPropertiesConfiguration.getPatternMessageLogger(0));
	}
	
	public void testSeparatorLoggers(){
		assertEquals("-",loaderPropertiesConfiguration.getSeparatorLogger(0));
	}
	
	public void testRegularExpresionLoggers(){
		assertEquals("^[a-zA-Z[:space:]]*$",loaderPropertiesConfiguration.getRegularExpresionLogger(0));
	}
	
	public void testCustomFilterLoggers(){
		Hashtable<String, String> hashCustomsFilters = new Hashtable<String, String>();
		
		hashCustomsFilters.put("%p","DEBUG");
		
		assertEquals(hashCustomsFilters,loaderPropertiesConfiguration.getCustomFilterLogger(0));
	}
}
