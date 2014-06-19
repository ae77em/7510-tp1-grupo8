package tp1_7510.grupo8.Logger;

import java.util.Map;
import java.util.HashMap;

public enum LogLevel {
        OFF,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        TRACE;
        
        LogLevel logLevel;
                
        private static final Map<String, LogLevel> logLevelsNameMap = new HashMap<String, LogLevel>();
        static {
            for (LogLevel logLevel:LogLevel.values()) {
                logLevelsNameMap.put(logLevel.name(), logLevel);
            }
        }
        
        LogLevel(){
    		this.logLevel= LogLevel.getLogLevel("DEBUG");
    	}
        
    	LogLevel(LogLevel logLevel){
    		this.logLevel= logLevel;
    	}
    	
    	public Boolean isLowerOrEqual(LogLevel logLevel){
    		return this.ordinal() <= logLevel.ordinal();				
    	}
    	
    	public void setLogLevel(LogLevel logLevel){
    		this.logLevel = logLevel;
    	}
    	
    	public LogLevel getLogLevel(){
    		return logLevel;
    	}
    	
        public static LogLevel getLogLevel(LogLevel logLevel) {
            return logLevelsNameMap.get(logLevel.toString());
        }
    	
        public static LogLevel getLogLevel(String logLevelName) {
            return logLevelsNameMap.get(logLevelName);
        }
    	
}


