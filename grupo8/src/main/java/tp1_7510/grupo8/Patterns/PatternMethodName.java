package tp1_7510.grupo8.Patterns;

public class PatternMethodName implements Pattern {

	String pattern;

	public PatternMethodName(String p) {
		pattern = p;
	}
	
	public PatternMethodName() {
		pattern = "%M";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
