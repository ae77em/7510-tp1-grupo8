package tp1_7510.grupo8.Printer;

import java.util.Hashtable;

public class ConsolePrinter extends Printer {

	public ConsolePrinter(Hashtable<String, String> dataConfiguration, Hashtable<String, String> filterCustom){
		super(dataConfiguration, filterCustom);
	}
	
	public void print(String aMessage){		
		System.out.println(aMessage);
	}

	public void close() {
		//metodo forzado a implementarse porque se hereda abstracto, no cierra nada ya que es la consola
	}
}
