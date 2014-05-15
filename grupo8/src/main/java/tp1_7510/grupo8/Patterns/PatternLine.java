package tp1_7510.grupo8.Patterns;

public class PatternLine implements Pattern {

	String pattern;

	public PatternLine(String p) {
		pattern = p;
	}
	
	public PatternLine() {
		System.out.println("CREE LINE");
		pattern = "%%";
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
