package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	public String addText(String s) {
        return s + Thread.currentThread().getName();
	}

	public String getText() {
		
		return Thread.currentThread().getName();
	}
	
	public String toString(){
		return "thread";
	}

}
