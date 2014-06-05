package org.slf4j.impl;
 
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
 
import java.util.HashMap;
import java.util.Map;
 
public class LoggerFactory implements ILoggerFactory {
    private Map<String, LoggerAdapter> loggerMap;
 
    public LoggerFactory() {
        loggerMap = new HashMap<String, LoggerAdapter>();
    }
 
    @Override
    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            if (!loggerMap.containsKey(name)) {
                loggerMap.put(name, new LoggerAdapter(name));
            }
 
            return loggerMap.get(name);
        }
    }
}