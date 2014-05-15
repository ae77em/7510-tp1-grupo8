package tp1_7510.grupo8.Patterns;

public class PatternMethodName implements Pattern {

	public PatternMethodName() {
		
	}
	
	@Override
	public String execute(String s) {
		//NI IDEA SI ANDA
		return  s + new Object(){}.getClass().getEnclosingMethod().getName();
	}

}
