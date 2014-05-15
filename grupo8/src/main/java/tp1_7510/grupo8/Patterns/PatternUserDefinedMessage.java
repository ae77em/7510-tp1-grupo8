package tp1_7510.grupo8.Patterns;

public class PatternUserDefinedMessage implements Pattern {

	String pattern;

	public PatternUserDefinedMessage(String p) {
		pattern = p;
	}
	
	public PatternUserDefinedMessage() {
		pattern = "%m";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
