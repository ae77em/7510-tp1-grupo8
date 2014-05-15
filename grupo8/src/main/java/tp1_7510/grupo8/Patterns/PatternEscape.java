package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {

	String m_escape;

	public PatternEscape(String p) {
		m_escape = p;
	}

	@Override
	public String formatText(String s) {
		return s + m_escape;
	}

}
