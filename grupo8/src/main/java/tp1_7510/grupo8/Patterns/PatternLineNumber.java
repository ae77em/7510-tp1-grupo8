package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	String pattern;

	public PatternLineNumber(String p) {
		pattern = p;
	}
	
	public PatternLineNumber() {
		pattern = "%L";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
