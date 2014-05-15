package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {

	String m_escape;

	public PatternEscape(String p) {
		m_escape = p;
	}

	@Override
	public String execute(String s) {
		return m_escape + s;
	}

}
