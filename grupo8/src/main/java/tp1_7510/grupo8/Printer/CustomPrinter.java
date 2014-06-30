package tp1_7510.grupo8.Printer;

import java.util.Hashtable;

import tp1_7510.grupo8.Printer.CustomDestiny;;

public class CustomPrinter extends Printer{
	
	private CustomDestiny output;


	public CustomPrinter(Hashtable<String, String> dataConfiguration,Hashtable<String, String> filterCustom) {
		super(dataConfiguration, filterCustom);			
	}
	
	public void print(String message) {
		
		setOutput(CustomDestiny.getInstance(message));	
		
	}

	
	public void close() {
		// TODO Auto-generated method stub
		
	}


	public CustomDestiny getOutput() {
		return output;
	}


	public void setOutput(CustomDestiny output) {
		this.output = output;
	}

}
