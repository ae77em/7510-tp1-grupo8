package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	String pattern;

	public PatternThread(String p) {
		pattern = p;
	}
	
	public PatternThread() {
		pattern = "%t";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
