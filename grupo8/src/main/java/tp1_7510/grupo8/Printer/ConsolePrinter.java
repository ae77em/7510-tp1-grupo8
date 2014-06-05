package tp1_7510.grupo8.Printer;

import java.util.Hashtable;

import org.json.simple.JSONObject;

import tp1_7510.grupo8.Patterns.Pattern;

public class ConsolePrinter extends Printer {

	public ConsolePrinter(Hashtable<String, String> dataConfiguration,Hashtable<String,String> filterCustom){
		super(dataConfiguration,filterCustom);
	}
	
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}
		
		System.out.println(messageFormated);
	}

	public void close() {
		//metodo forzado a implementarse porque se hereda abstracto, no cierra nada ya que es la consola
	}
}
