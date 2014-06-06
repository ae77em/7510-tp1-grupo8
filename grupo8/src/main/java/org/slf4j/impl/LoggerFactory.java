package org.slf4j.impl;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import tp1_7510.grupo8.Configurator;

import java.util.HashMap;
import java.util.Map;
 
public class LoggerFactory implements ILoggerFactory {
	
	private Map<String, LoggerAdapter> loggerMap;
    
    public LoggerFactory() {
        
    	loggerMap = new HashMap<String,LoggerAdapter>();
        
        Configurator configurator = new Configurator();
		JSONObject jsonConfig = configurator.getConfigurationLogger();
		JSONArray jsonArrayConfigLoggers = (JSONArray) jsonConfig.get("loggers");
		  
		for(int i=0; i<jsonArrayConfigLoggers.size();i++){
			JSONObject aConfigLogger = (JSONObject) jsonArrayConfigLoggers.get(i);
			loggerMap.put(aConfigLogger.get("name").toString(), new LoggerAdapter( (JSONObject) jsonArrayConfigLoggers.get(i) ));			   
		}        
    }
 
    public Logger getLogger(String name) { 
        return loggerMap.get(name);        
    }
}