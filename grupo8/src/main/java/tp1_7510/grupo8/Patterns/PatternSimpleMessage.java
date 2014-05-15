package tp1_7510.grupo8.Patterns;

public class PatternSimpleMessage implements Pattern {
	
	private String m_simpleText;
	
	public PatternSimpleMessage(){
		m_simpleText = "";
	}
	
	public PatternSimpleMessage(String text){
		m_simpleText = text;
	}
	
	@Override //imprime el mensaje, el mismo estomado de una variable estatico en la clase LOGGER
	public String addText(String s) {
		return s + m_simpleText;
	}
	@Override
	public String getText() {		
		return m_simpleText;
	}

}
