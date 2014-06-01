package tp1_7510.grupo8.Patterns;

public class PatternPrinterName implements Pattern {

	String fileName;

	public PatternPrinterName(String p) {
		fileName = p;
	}
	
	public String addText(String s) {
		return  s + fileName;
	}

	public String getText() {
		return fileName;
	}
	
	public String toString(){
		return "printerName";
	}
	
}
