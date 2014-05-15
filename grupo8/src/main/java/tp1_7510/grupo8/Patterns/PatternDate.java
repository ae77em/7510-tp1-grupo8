package tp1_7510.grupo8.Patterns;

public class PatternDate implements Pattern {
	
	String pattern;

	public PatternDate(String p) {
		pattern = p;
	}
	
	public PatternDate() {
		pattern = "%d{dd/mm/aaaa}";
	}
	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

}
