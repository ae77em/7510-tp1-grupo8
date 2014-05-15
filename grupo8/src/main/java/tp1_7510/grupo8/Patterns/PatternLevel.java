package tp1_7510.grupo8.Patterns;

public class PatternLevel implements Pattern {

	String m_level;

	public PatternLevel(String p) {
		m_level = p;
	}
	
	@Override //se imprime nivel de level
	public String formatText(String s) {
		return s + m_level;
	}

}
