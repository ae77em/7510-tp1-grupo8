package tp1_7510.grupo8.Patterns;

public class PatternFilename implements Pattern {

	String m_fileName;

	public PatternFilename(String p) {
		m_fileName = p;
	}
	
	@Override
	public String execute(String s) {
		return s += m_fileName;
	}

}
