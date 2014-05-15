package tp1_7510.grupo8.Patterns;

public class PatternDate implements Pattern {
	
	String pattern;

	public PatternDate(String p) {
		pattern = p;
	}	
	
	public void configurePattern(String p) {
		pattern = p;
	}
	
	public String getPattern(){
		return this.pattern;
	}

	@Override
	public String execute(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
