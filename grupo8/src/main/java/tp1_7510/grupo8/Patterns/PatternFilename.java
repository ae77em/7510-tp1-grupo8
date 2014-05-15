package tp1_7510.grupo8.Patterns;

public class PatternFilename implements Pattern {

	String pattern;

	public PatternFilename(String p) {
		pattern = p;
	}
	
	public PatternFilename() {
		System.out.println("FILE NAME");
		pattern = "%F";
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
