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

public class FilePrinter implements Printer 
{
	private PrintWriter m_Writter;
	
	private ArrayList<Pattern> messagePatterns;//contendra los patrones a aplicar al mensaje
	private FactoryPatterns factoryPatterns;//fabrica los patrones a aplicar al mensaje
	
	/*
	 * recibe la configuracion de un archivo, lo crea y le pasa las reglas a la clase
	 * factoryPattern para que las instancie
	 */
	public FilePrinter(Hashtable<String,String> dataConfiguration) throws FileNotFoundException{
		m_Writter = new PrintWriter(new FileOutputStream(new File(dataConfiguration.get("name"))));
				
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		messagePatterns = factoryPatterns.createListOfPatterns();
	}
	
	/*
	 * formatee el texto y lo baja a disco
	 */
	public void print(String aMessage){		
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.formatText(messageFormated);
		}
		
		m_Writter.println(messageFormated);
	}
	
	/*
	 * cierra el archivo
	 */
	public void close() {
		m_Writter.close();
	}
}
