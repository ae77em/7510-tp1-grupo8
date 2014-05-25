package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	@Override 
	public String addText(String s) {
        return s + Thread.currentThread().getName();
	}

	@Override
	public String getText() {
		
		return Thread.currentThread().getName();
	}

}
