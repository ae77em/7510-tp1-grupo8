package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ParserJsonConfig{
	LoaderConfiguration loaderConfiguration;
	
	public ParserJsonConfig(LoaderConfiguration aLoaderConfiguration){
		loaderConfiguration = aLoaderConfiguration;
	}

	public JSONObject getConfigLoggers() {
		JSONObject configLoggers = new JSONObject();
		JSONArray jsonArrayConfigLogger = new JSONArray();

		int cantidadLoggers = loaderConfiguration.getLenghtLoggers();
			
		for(int i=0; i<cantidadLoggers;i++){
			jsonArrayConfigLogger.add( getConfigurationLogger( i ) );
		}
		
		configLoggers.put("loggers",jsonArrayConfigLogger);
		
		return configLoggers;
	}

	public JSONObject getConfigurationLogger(int i) {
		//la estructura es un vector NOMBRELOGGER : { JsonCaracteristicas }
		JSONObject configALogger = new JSONObject();
		
		configALogger.put("name", loaderConfiguration.getNameLogger(i) );
		configALogger.put("levelLog", loaderConfiguration.getLevelLogLogger(i) );
		configALogger.put("type",loaderConfiguration.getTypeLogger(i));
		configALogger.put("name",loaderConfiguration.getNameLogger(i));
		configALogger.put("fileName",loaderConfiguration.getFileNameLogger(i));
		configALogger.put("formatDate",loaderConfiguration.getFormatDateLogger(i));
		configALogger.put("patternMessage",loaderConfiguration.getPatternMessageLogger(i));
		configALogger.put("separator",loaderConfiguration.getSeparatorLogger(i));
		configALogger.put("regularExpresion",loaderConfiguration.getRegularExpresionLogger(i));
		configALogger.put("customFilter", getCustomFilters(i) );
		
		return configALogger;
	}

	private JSONArray getCustomFilters(int i) {
		JSONArray jsonArrayCustomFilter = new JSONArray();
		
		Hashtable<String, String> hashCustomsFilters = loaderConfiguration.getCustomFilterLogger(i);
		
		Set<String> set = hashCustomsFilters.keySet(); //obtengo los cod de pattern

	    Iterator<String> itr = set.iterator();
	    
	    while (itr.hasNext()){
			JSONObject jsonCustomFilter = new JSONObject();
			JSONObject patternRegExp = new JSONObject();
		    String key = itr.next();
		    String expRegular = hashCustomsFilters.get(key);
		    
		    patternRegExp.put("pattern", key);
		    patternRegExp.put("value", expRegular);
		    
		    jsonCustomFilter.put("key",patternRegExp);
		    
		    jsonArrayCustomFilter.add(jsonCustomFilter);
		}
		
		return jsonArrayCustomFilter;
	}

}
