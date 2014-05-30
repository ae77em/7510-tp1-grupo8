package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {
	
	public PatternEscape() {
		
	}

	public String addText(String s) {
		return s + "%";
	}

	public String getText() {
		return "%";
	}

}
