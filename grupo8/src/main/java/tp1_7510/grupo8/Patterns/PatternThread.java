package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	@Override
	public String execute(String s) {
        return Thread.currentThread().getName() + s;
	}

}
