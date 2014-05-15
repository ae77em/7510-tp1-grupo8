package tp1_7510.grupo8.Patterns;

public class PatternSeparator implements Pattern {

	String pattern;

	public PatternSeparator(String p) {
		pattern = p;
	}
	
	public PatternSeparator() {
		pattern = "%n";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
