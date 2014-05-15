package tp1_7510.grupo8.Patterns;

public class PatternFilename implements Pattern {

	String pattern;

	public PatternFilename(String p) {
		pattern = p;
	}
	
	public PatternFilename() {
		pattern = "%F";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
