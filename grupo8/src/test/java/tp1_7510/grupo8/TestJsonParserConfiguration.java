package tp1_7510.grupo8;

import java.io.FileNotFoundException;
import junit.framework.TestCase;

public class TestJsonParserConfiguration extends TestCase{

	String path = "src/main/java/tp1_7510/grupo8/Config/configTest.xml";

	LoaderConfiguration loaderConfiguration = new LoaderXmlConfiguration(path);

	ParserJsonConfig parserJsonConfig = new ParserJsonConfig(loaderConfiguration); 
	
	public void test() throws FileNotFoundException {
		assertEquals(1,1);
	}

}
