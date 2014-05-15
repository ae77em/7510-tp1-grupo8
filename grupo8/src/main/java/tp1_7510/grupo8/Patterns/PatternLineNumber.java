package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	int m_numberLine;

	public PatternLineNumber() {
		m_numberLine=1;
	}
	
	@Override //se imprime nro de linea de logueo
	public String formatText(String s) {
		String message = s + Integer.toString(m_numberLine);

		m_numberLine++;
		
		return message;
	}


}
