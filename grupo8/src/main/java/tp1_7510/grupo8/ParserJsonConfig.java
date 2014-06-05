package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ParserJsonConfig {
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

	private Object getConfigurationLogger(int i) {
		//la estructura es un vector NOMBRELOGGER : { JsonCaracteristicas }
		JSONObject configALogger = new JSONObject();
		
		configALogger.put(loaderConfiguration.getNameLogger(i), getCaracteristicasLogger(i) );
		
		return configALogger;
	}

	private JSONObject getCaracteristicasLogger(int i) {
		JSONObject configALogger = new JSONObject();
		
		configALogger.put("type",loaderConfiguration.getTypeLogger(i));
		configALogger.put("fileName",loaderConfiguration.getFileNameLogger(i));
		configALogger.put("formatDate",loaderConfiguration.getFormatDateLogger(i));
		configALogger.put("patternMessage",loaderConfiguration.getPatternMessageLogger(i));
		configALogger.put("separator",loaderConfiguration.getSeparatorLogger(i));
		configALogger.put("regularExpresion",loaderConfiguration.getRegularExpresionLogger(i));
		configALogger.put("customFilter", getCustomFilters(i) );
		
		return configALogger;
	}

	private Object getCustomFilters(int i) {
		JSONArray jsonArrayCustomFilter = new JSONArray();
		
		Hashtable<String, String> hashCustomsFilters = loaderConfiguration.getCustomFilterLogger(i);
		
		Set<String> set = hashCustomsFilters.keySet(); //obtengo los cod de pattern

	    Iterator<String> itr = set.iterator();
	    
	    while (itr.hasNext()) {
			JSONObject jsonCustomFilter = new JSONObject();
		    String key = itr.next();
		    String expRegular = hashCustomsFilters.get(key);
		    
		    jsonCustomFilter.put(key,expRegular);
		    
		    jsonArrayCustomFilter.add(jsonCustomFilter);
		}
		
		return jsonArrayCustomFilter;
	}

}
