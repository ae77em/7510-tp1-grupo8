package tp1_7510.grupo8.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

public class ConsolePrinter implements Printer {

	private ArrayList<Pattern> messagePatterns; //contendra los patrones a aplicar al mensaje
	private FactoryPatterns factoryPatterns;//fabrica los patrones a aplicar al mensaje

	
	/*
	 * recibe un hash con la configuracion de la salida a loguear
	 */
	public ConsolePrinter(Hashtable<String, String> dataConfiguration){
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		messagePatterns = factoryPatterns.createListOfPatterns();
	}
	
	/*
	 *formatea el mensaje y lo imprime 
	 */
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.formatText(messageFormated);
			System.out.println(messageFormated);
		}
		
		System.out.println(messageFormated);
	}

	public void close() {

	}
}
