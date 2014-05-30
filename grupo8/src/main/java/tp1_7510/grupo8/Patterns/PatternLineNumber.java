package tp1_7510.grupo8.Patterns;

public class PatternLineNumber implements Pattern {

	int numberLine;

	public PatternLineNumber() {
		numberLine=0;
	}
	
	public String addText(String s) {
		String message = s + Integer.toString(numberLine);

		numberLine++;
		
		return message;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return Integer.toString(numberLine);
	}

	

}
