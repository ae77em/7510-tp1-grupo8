package tp1_7510.grupo8.Printer;

import java.util.Hashtable;
import tp1_7510.grupo8.Patterns.Pattern;

public class ConsolePrinter extends Printer {

	/*
	 * recibe un hash con la configuracion de la salida a loguear
	 */
	public ConsolePrinter(Hashtable<String, Object> dataConfiguration){
		super(dataConfiguration);
	}
	
	/*
	 *formatea el mensaje y lo imprime 
	 */
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}
		
		System.out.println(messageFormated);
	}

	public void close() {

	}
}
