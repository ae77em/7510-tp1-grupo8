package tp1_7510.grupo8;

import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import junit.framework.TestCase;

public class TestJsonParserConfiguration extends TestCase{

	String path = "src/main/java/tp1_7510/grupo8/Config/test/config.xml";

	LoaderConfiguration loaderConfiguration = new LoaderXmlConfiguration(path);

	ParserJsonConfig parserJsonConfig = new ParserJsonConfig(loaderConfiguration); 
	
	public JSONObject createMockJsonConfig(){
		JSONObject configALogger = new JSONObject();
		
		configALogger.put("name","LogParser");
		configALogger.put("levelLog","DEBUG");
		configALogger.put("type","FILES");
		configALogger.put("fileName","parserLog");
		configALogger.put("formatDate","dd-M-yyyy hh:mm:ss");
		configALogger.put("patternMessage","%d%s%l%s");
		configALogger.put("separator","-");
		configALogger.put("regularExpresion","Expresion1");
//		configALogger.put("customFilter",  );
		
		return null;
	}
	
	public void test() throws FileNotFoundException {
		assertEquals(1,1);
	}

}
