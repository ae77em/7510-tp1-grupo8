package tp1_7510.grupo8.Patterns;

public class PatternSeparator implements Pattern {

	String m_separator;

	public PatternSeparator(String p) {
		m_separator = p;
	}
	
	@Override
	public String formatText(String s) {
		return s + m_separator;
	}

}
