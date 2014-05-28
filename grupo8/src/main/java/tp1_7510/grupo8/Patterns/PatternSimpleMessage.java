package tp1_7510.grupo8.Patterns;

public class PatternSimpleMessage implements Pattern {
	
	private String simpleText;
	
	public PatternSimpleMessage(){
		simpleText = "";
	}
	
	public PatternSimpleMessage(String text){
		simpleText = text;
	}
	
	@Override
	public String addText(String s) {
		return s + simpleText;
	}
	@Override
	public String getText() {		
		return simpleText;
	}

}
