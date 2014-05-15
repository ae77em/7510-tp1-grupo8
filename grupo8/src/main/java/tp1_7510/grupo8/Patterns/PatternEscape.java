package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {
	
	public PatternEscape() {
		
	}

	@Override //imprime un caracter de escape
	public String addText(String s) {
		return s + "%";
	}

	@Override
	public String getText() {
		return "%";
	}

}
