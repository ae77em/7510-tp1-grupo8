package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.*;

public class PatternLevel implements Pattern {

	String m_level;
	
	public PatternLevel() {
		m_level = LogLevel.DEBUG.toString();
	}

	public PatternLevel(String p) {
		m_level = p;
	}
	
	@Override //se imprime nivel de level
	public String addText(String s) {
		return s + m_level;
	}

	@Override
	public String getText() {		
		return m_level;
	}

}
