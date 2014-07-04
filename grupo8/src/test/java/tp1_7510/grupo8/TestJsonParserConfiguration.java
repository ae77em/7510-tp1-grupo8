package tp1_7510.grupo8;
	
import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import tp1_7510.grupo8.ConfigurationLoaders.LoaderConfiguration;
import tp1_7510.grupo8.ConfigurationLoaders.LoaderPropertiesConfiguration;
import tp1_7510.grupo8.ConfigurationLoaders.ParserJsonConfig;
	
	public class TestJsonParserConfiguration{

		String path = "src/test/java/tp1_7510/grupo8/testOutputFiles/testConfig/config.properties";

		LoaderConfiguration loaderConfiguration = new LoaderPropertiesConfiguration(path);
	
		ParserJsonConfig parserJsonConfig = new ParserJsonConfig(loaderConfiguration);
	
		private JSONArray createMockArrayFilterCustom(){
			JSONArray jsonArrayCustomFilter = new JSONArray();
	
			jsonArrayCustomFilter.add( createKeyMockFilter("%p","DEBUG"));
	
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
			configALogger.put("type","FILES");
			configALogger.put("fileName","aFileName1");
			configALogger.put("formatDate","dd-MM-yyyy hh:mm");
			configALogger.put("patternMessage","%F-%n-%p-%n-%t-%n-%m");
			configALogger.put("separator","-");
			configALogger.put("regularExpresion","^[a-zA-Z[:space:]]*$");
			configALogger.put("customFilter", createMockArrayFilterCustom() );
			configALogger.put("customClassName", "aClass" );
	
			return configALogger;
		}

		@Test
		public void testParserAPrinter(){
			JSONObject aConfigurationPrinter = parserJsonConfig.getConfigurationLogger(0); //obtengo la configuracion del primer printer
	
			JSONObject aConfigurationPrinterMock = createMockJsonConfig();
	
			System.out.println(aConfigurationPrinter);
			System.out.println(aConfigurationPrinterMock);
			
			assertEquals(aConfigurationPrinter,aConfigurationPrinterMock);
		}
}