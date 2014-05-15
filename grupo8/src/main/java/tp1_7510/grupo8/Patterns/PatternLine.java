package tp1_7510.grupo8.Patterns;

public class PatternLine implements Pattern {

	String pattern;

	public PatternLine(String p) {
		pattern = p;
	}
	
	public PatternLine() {
		pattern = "%%";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
