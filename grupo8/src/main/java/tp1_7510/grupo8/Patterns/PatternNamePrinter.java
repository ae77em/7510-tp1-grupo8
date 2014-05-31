package tp1_7510.grupo8.Patterns;

public class PatternNamePrinter implements Pattern {

	String fileName;

	public PatternNamePrinter(String p) {
		fileName = p;
	}
	
	public String addText(String s) {
		return  s + fileName;
	}

	public String getText() {
		return fileName;
	}

}
