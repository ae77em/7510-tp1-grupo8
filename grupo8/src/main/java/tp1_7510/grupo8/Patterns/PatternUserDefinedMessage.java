package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Logger;
import tp1_7510.grupo8.Printer.FilePrinter;

public class PatternUserDefinedMessage implements Pattern {

	public PatternUserDefinedMessage() {
		
	}
	
	@Override 
	public String addText(String s) {
		return s + Logger.message;
	}

	@Override
	public String getText() {
		return Logger.message;
	}

}
