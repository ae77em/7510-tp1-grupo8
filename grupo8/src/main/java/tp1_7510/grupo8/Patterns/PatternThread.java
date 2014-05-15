package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	String pattern;

	public PatternThread(String p) {
		pattern = p;
	}
	
	public PatternThread() {
		System.out.println("CREE THREAD");
		pattern = "%t";
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
