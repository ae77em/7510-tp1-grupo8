package tp1_7510.grupo8.Patterns;

public class PatternThread implements Pattern {

	@Override //imprime el nombre del Thread
	public String addText(String s) {
        return s + Thread.currentThread().getName();
	}

}
