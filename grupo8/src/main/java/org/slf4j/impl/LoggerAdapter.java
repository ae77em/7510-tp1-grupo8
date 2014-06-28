package org.slf4j.impl;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.Marker; 

public class LoggerAdapter implements Logger {
	
	private tp1_7510.grupo8.Logger.Logger logger;

	public LoggerAdapter(JSONObject jsonObject) {
		logger = new tp1_7510.grupo8.Logger.Logger(jsonObject);
	}

	public void debug(String message) {
		logger.debug(message);		
	}


	public void debug(String message, Throwable throwable) {
		logger.debug(message,throwable);
		
	}
	
	public void fatal(String message) {
		logger.fatal(message);		
	}


	public void fatal(String message, Throwable throwable) {
		logger.fatal(message,throwable);
		
	}
	
	public void off(String message) {
		logger.off(message);		
	}


	public void off(String message, Throwable throwable) {
		logger.off(message,throwable);
		
	}


	public void error(String message) {
		logger.error(message);
		
	}


	public void error(String message, Throwable throwable) {
		logger.error(message,throwable);
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public void info(String message) {
		logger.info(message);
		
	}


	public void info(String message, Throwable throwable) {
		logger.info(message,throwable);
		
	}


	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isDebugEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isErrorEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isInfoEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isTraceEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isWarnEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public void trace(String message) {
		logger.trace(message);		
	}


	public void trace(String message, Throwable throwable) {
		logger.trace(message,throwable);
		
	}


	public void warn(String message) {
		logger.warn(message);		
	}


	public void warn(String message, Throwable throwable) {
		logger.warn(message,throwable);
		
	}
	

	public void debug(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void debug(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}


	public void debug(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	public void debug(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void debug(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void debug(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}


	public void debug(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}


	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}


	public void error(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void error(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}


	public void error(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	public void error(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void error(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void error(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}


	public void error(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}


	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}


	public void info(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void info(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}


	public void info(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	public void info(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void info(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void info(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}


	public void info(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}


	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}


	public void trace(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void trace(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}


	public void trace(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	public void trace(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void trace(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void trace(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}


	public void trace(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}


	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}


	public void warn(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void warn(String arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}


	public void warn(Marker arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	public void warn(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void warn(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	public void warn(Marker arg0, String arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}


	public void warn(Marker arg0, String arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}


	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	} 
}

