package tp1_7510.grupo8.Patterns;

public class PatternSeparator implements Pattern {

	String separator;
	
	public PatternSeparator() {
		separator = "-";
	}

	public PatternSeparator(String p) {
		separator = p;
	}
	
	@Override
	public String addText(String s) {
		return s + separator;
	}

	@Override
	public String getText() {
		return separator;
	}

}
