package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	String pattern;

	public PatternLineNumber(String p) {
		pattern = p;
	}
	
	public PatternLineNumber() {
		System.out.println("CREE LINE NUMBER");
		pattern = "%L";
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
