package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Logger;
import tp1_7510.grupo8.Printer.FilePrinter;

public class PatternUserDefinedMessage implements Pattern {

	public PatternUserDefinedMessage() {
		
	}
	
	@Override
	public String formatText(String s) {
		//es el mensaje en si, por lo atnto solo lo deuvelve
		return s + Logger.message;
	}

}
