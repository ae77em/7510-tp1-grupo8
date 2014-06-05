package tp1_7510.grupo8.Printer;

import java.io.*;
import java.util.Hashtable;

import org.json.simple.JSONObject;

import tp1_7510.grupo8.ControllerMessage;
import tp1_7510.grupo8.Patterns.Pattern;

public class FilePrinter extends Printer{

	private PrintWriter writter;

	public FilePrinter(Hashtable<String, String> dataConfiguration,Hashtable<String,String> filterCustom) throws FileNotFoundException{
		
		super(dataConfiguration,filterCustom);
		
		writter = new PrintWriter(new FileOutputStream(new File((String) dataConfiguration.get("name"))));
	}
	
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}
		
		writter.println(messageFormated);
	}
	
	public void close() {
		writter.close();
	}
}
