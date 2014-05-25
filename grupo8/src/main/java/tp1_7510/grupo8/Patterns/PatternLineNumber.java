package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	int m_numberLine;

	public PatternLineNumber() {
		m_numberLine=0;
	}
	
	@Override 
	public String addText(String s) {
		String message = s + Integer.toString(m_numberLine);

		m_numberLine++;
		
		return message;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return Integer.toString(m_numberLine);
	}

	

}
