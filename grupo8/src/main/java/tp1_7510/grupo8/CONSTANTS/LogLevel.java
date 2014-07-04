package tp1_7510.grupo8.CONSTANTS;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public enum LogLevel {
        OFF("OFF"),
        FATAL("FATAL"),
        ERROR("ERROR"),
        WARN("WARN"),
        INFO("INFO"),
        DEBUG("DEBUG"),
        TRACE("TRACE");
        
        String logLevel;
                
        private static final Map<String, LogLevel> logLevelsNameMap = Collections.unmodifiableMap(initializeLog());
        
        private static Map<String, LogLevel> initializeLog(){
        	
        	Map<String, LogLevel> lMap = new HashMap<String, LogLevel>();
        	
        	for (LogLevel logLevel:LogLevel.values()) {
        		lMap.put(logLevel.name(), logLevel);
            }
        	
        	return lMap;
        }
        
        LogLevel(){
    		this.logLevel= "DEBUG";
    	}
        
    	LogLevel(String logLevel){
    		this.logLevel= logLevel;
    	}
    	
    	public Boolean isLowerOrEqual(LogLevel logLevel){
    		return this.ordinal() >= logLevel.ordinal();				
    	}
    	
    	public void setLogLevel(LogLevel logLevel){
    		this.logLevel = logLevel.name();
    	}
    	
    	public void setLogLevel(String logLevel){
    		this.logLevel = logLevel;
    	}
    	
    	public LogLevel getLogLevel(){
    		return logLevelsNameMap.get(this.logLevel);
    	}
    	
        public static LogLevel getLogLevel(LogLevel logLevel) {
            return logLevelsNameMap.get(logLevel.toString());
        }
    	
        public static LogLevel getLogLevel(String logLevelName) {
            return logLevelsNameMap.get(logLevelName);
        }
}


