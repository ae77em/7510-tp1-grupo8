package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.*;

public class PatternLevel implements Pattern {

	LogLevel level;
	
	public PatternLevel() {
		level = LogLevel.DEBUG;
	}

	public PatternLevel(LogLevel p) {
		level = p;
	}
	
	@Override 
	public String addText(String s) {
		return s + level.toString();
	}

	@Override
	public String getText() {		
		return level.toString();
	}

}