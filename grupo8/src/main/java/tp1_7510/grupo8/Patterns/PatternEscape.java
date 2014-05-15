package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {

	String pattern;

	public PatternEscape(String p) {
		pattern = p;
	}
	
	public PatternEscape() {
		pattern = "%%";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
