package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	@Override
	public String formatText(String s) {
        return s + Thread.currentThread().getName();
	}

}
