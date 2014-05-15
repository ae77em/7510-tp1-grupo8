package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Printer.FilePrinter;

public class PatternUserDefinedMessage implements Pattern {

	public PatternUserDefinedMessage() {
		
	}
	
	@Override
	public String execute(String s) {
		//es el mensaje en si, por lo atnto solo lo deuvelve
		return FilePrinter.message + s ;
	}

}
