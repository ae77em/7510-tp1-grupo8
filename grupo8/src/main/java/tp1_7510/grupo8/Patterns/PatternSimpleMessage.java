package tp1_7510.grupo8.Patterns;

public class PatternSimpleMessage implements Pattern {
	
	private String m_simpleText;
	
	public PatternSimpleMessage(String text){
		m_simpleText = text;
	}
	@Override
	public String formatText(String s) {
		// TODO Auto-generated method stub
		return s + m_simpleText;
	}

}
