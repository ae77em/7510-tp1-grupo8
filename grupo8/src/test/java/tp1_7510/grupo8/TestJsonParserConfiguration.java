package tp1_7510.grupo8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import junit.framework.TestCase;

public class TestJsonParserConfiguration extends TestCase{

	String path = "src/main/java/tp1_7510/grupo8/Config/test/config.properties";

	LoaderConfiguration loaderConfiguration = new LoaderPropertiesConfiguration(path);

	ParserJsonConfig parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
	
	private JSONArray createMockArrayFilterCustom(){
		JSONArray jsonArrayCustomFilter = new JSONArray();
		
		jsonArrayCustomFilter.add( createKeyMockFilter("%T","filter%T"));
		jsonArrayCustomFilter.add( createKeyMockFilter("%s","filter%s"));
		jsonArrayCustomFilter.add( createKeyMockFilter("%d","filter%d"));
		jsonArrayCustomFilter.add( createKeyMockFilter("%l","filter%l"));
	    
	    return jsonArrayCustomFilter;
	}
	
	private JSONObject createKeyMockFilter(String pattern, String filter) {
		JSONObject patternRegExp = new JSONObject();
		JSONObject jsonCustomFilter = new JSONObject();
		
		patternRegExp.put("pattern", pattern);
	    patternRegExp.put("value", filter);
	    
	    jsonCustomFilter.put("key",patternRegExp);		
		
		return jsonCustomFilter;
	}

	public JSONObject createMockJsonConfig(){
		
		JSONObject configALogger = new JSONObject();
		
		configALogger.put("name","filer1");
		configALogger.put("levelLog","DEBUG");
		configALogger.put("type","file");
		configALogger.put("fileName","aFileName1");
		configALogger.put("formatDate","dd-M-yyyy hh:mm:ss");
		configALogger.put("patternMessage","%d%s%l%s");
		configALogger.put("separator","-");
		configALogger.put("regularExpresion","^[a-zA-Z0-9]*$");
		configALogger.put("customFilter", createMockArrayFilterCustom() );
		
		return configALogger;
	}
	
	public void testParserAPrinter(){
		JSONObject aConfigurationPrinter = parserJsonConfig.getConfigurationLogger(0); //obtengo la configuracion del primer printer
		
		JSONObject aConfigurationPrinterMock = createMockJsonConfig();
		
		assertEquals(aConfigurationPrinter,aConfigurationPrinterMock);
	}
}
