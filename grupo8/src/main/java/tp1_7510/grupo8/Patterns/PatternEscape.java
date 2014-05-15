package tp1_7510.grupo8.Patterns;

public class PatternEscape implements Pattern {
	public PatternEscape() {
		
	}

	@Override
	public String formatText(String s) {
		return s + "%";
	}

}
