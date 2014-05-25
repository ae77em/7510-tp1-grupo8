package tp1_7510.grupo8.Patterns;

public class PatternSimpleMessage implements Pattern {
	
	private String m_simpleText;
	
	public PatternSimpleMessage(){
		m_simpleText = "";
	}
	
	public PatternSimpleMessage(String text){
		m_simpleText = text;
	}
	
	@Override
	public String addText(String s) {
		return s + m_simpleText;
	}
	@Override
	public String getText() {		
		return m_simpleText;
	}

}
