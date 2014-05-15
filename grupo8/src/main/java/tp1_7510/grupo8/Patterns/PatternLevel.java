package tp1_7510.grupo8.Patterns;

public class PatternLevel implements Pattern {

	String pattern;

	public PatternLevel(String p) {
		pattern = p;
	}
	
	public PatternLevel() {
		pattern = "%p";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
