package tp1_7510.grupo8.Patterns;

public class PatternSimpleMessage implements Pattern {
	
	private String simpleText;
	
	public PatternSimpleMessage(){
		simpleText = "";
	}
	
	public PatternSimpleMessage(String text){
		simpleText = text;
	}
	
	public String addText(String s) {
		return s + simpleText;
	}

	public String getText() {		
		return simpleText;
	}
	
	public String setText(String aMessage){		
		return simpleText = aMessage;
	}
	
	public String toString(){
		return "simpleMessage";
	}
	
}
