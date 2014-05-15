package tp1_7510.grupo8.Patterns;

public class PatternUserDefinedMessage implements Pattern {

	String pattern;

	public PatternUserDefinedMessage(String p) {
		System.out.println("CREE USER DEFINE");
		pattern = p;
	}
	
	public PatternUserDefinedMessage() {
		System.out.println("CREE USER DEFINE");
		pattern = "%m";
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
