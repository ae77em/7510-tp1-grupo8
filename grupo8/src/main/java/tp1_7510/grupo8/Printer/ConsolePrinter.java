package tp1_7510.grupo8.Printer;

import java.util.Hashtable;
import tp1_7510.grupo8.Patterns.Pattern;

public class ConsolePrinter extends Printer {

	public ConsolePrinter(Hashtable<String, String> dataConfiguration){
		super(dataConfiguration);
	}
	
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}
		
		System.out.println(messageFormated);
	}
}
