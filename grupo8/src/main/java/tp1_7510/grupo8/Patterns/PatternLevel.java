package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.CONSTANTS.LogLevel;
import tp1_7510.grupo8.Logger.Logger;

public class PatternLevel implements Pattern {

	LogLevel level;
	
	public PatternLevel() {
		level = LogLevel.DEBUG;
	}

	public PatternLevel(LogLevel logLevel) {
		level = logLevel;
	}
	 
	public String addText(String s) {
		return s + Logger.level;
	}

	public String getText() {		
		return Logger.level;
	}
	
	public String toString(){
		return "logLevel";
	}

}
