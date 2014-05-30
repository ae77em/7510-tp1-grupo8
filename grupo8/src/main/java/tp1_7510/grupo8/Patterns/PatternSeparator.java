package tp1_7510.grupo8.Patterns;

public class PatternSeparator implements Pattern {

	String separator;
	
	public PatternSeparator() {
		separator = "-";
	}

	public PatternSeparator(String p) {
		separator = p;
	}
	
	public String addText(String s) {
		return s + separator;
	}

	public String getText() {
		return separator;
	}

}
