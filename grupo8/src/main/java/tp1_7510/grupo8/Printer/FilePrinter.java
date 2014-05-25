package tp1_7510.grupo8.Printer;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternDate;
import tp1_7510.grupo8.Patterns.PatternEscape;
import tp1_7510.grupo8.Patterns.PatternFilename;
import tp1_7510.grupo8.Patterns.PatternLevel;
import tp1_7510.grupo8.Patterns.PatternLineNumber;
import tp1_7510.grupo8.Patterns.PatternMethodName;
import tp1_7510.grupo8.Patterns.PatternSeparator;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;
import tp1_7510.grupo8.Patterns.PatternThread;
import tp1_7510.grupo8.Patterns.PatternUserDefinedMessage;

public class FilePrinter extends Printer{

	private PrintWriter writter;
	
	/*
	 * recibe la configuracion de un archivo, lo crea y le pasa las reglas a la clase
	 * factoryPattern para que las instancie
	 */
	public FilePrinter(Hashtable<String,String> dataConfiguration) throws FileNotFoundException{
		super(dataConfiguration);
		
		writter = new PrintWriter(new FileOutputStream(new File(dataConfiguration.get("name"))));
	}
	
	/*
	 * formatee el texto y lo baja a disco
	 */
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}
		
		writter.println(messageFormated);
	}
	
	/*
	 * cierra el archivo
	 */
	public void close() {
		writter.close();
	}
}
