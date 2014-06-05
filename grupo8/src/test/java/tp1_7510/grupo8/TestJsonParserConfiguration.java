package tp1_7510.grupo8;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import junit.framework.TestCase;

import org.json.simple.JSONObject;
import org.junit.Test;

public class TestJsonParserConfiguration extends TestCase{

	String path = "src/main/java/tp1_7510/grupo8/Config/configTest.xml";

	LoaderConfiguration loaderConfiguration = new LoaderXmlConfiguration(path);

	ParserJsonConfig parserJsonConfig = new ParserJsonConfig(loaderConfiguration); 
	
	public void test() throws FileNotFoundException {
		assertEquals(1,1);
	}

}
