package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	int m_numberLine;

	public PatternLineNumber() {
		m_numberLine=1;
	}
	
	@Override
	public String execute(String s) {
		String message = s + Integer.toString(m_numberLine);
		m_numberLine++;
		
		return message;
	}


}
