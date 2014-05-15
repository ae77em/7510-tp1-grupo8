package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Logger;
import tp1_7510.grupo8.Printer.FilePrinter;

public class PatternUserDefinedMessage implements Pattern {

	public PatternUserDefinedMessage() {
		
	}
	
	@Override //imprime algun mensaje que el usuario setee en el formato del mensaje
	public String addText(String s) {
		//es el mensaje en si, por lo atnto solo lo deuvelve
		return s + Logger.message;
	}

	@Override
	public String getText() {
		return Logger.message;
	}

}
