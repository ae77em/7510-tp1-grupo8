package tp1_7510.grupo8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	public static String message = "";
	
	private ArrayList<Printer> printers = new ArrayList<Printer>(); //lista que contendra todas las clases que impriman mensajes
	
	/*
	 * El constructor toma un hash con las consolas y los archivos a donde loguear los mensajes
	 * cada item de las lista contiene un hash que tiene la configuracion de cada LOG
	 * */
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> dataConfiguration){
		
		printers.addAll( createPrintersConsole(dataConfiguration.get("CONSOLES")));

		printers.addAll( createPrintersFile(dataConfiguration.get("FILES")));
	}
	
	/*
	 * recorre la lista de FILES a donde loguear y lanza una instancia por cada archivo
	 * 
	 */
	private ArrayList<Printer> createPrintersFile(ArrayList<Hashtable<String,String>> printersFiles) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aFilePrinter : printersFiles){
		    try {
				printers.add( new FilePrinter(aFilePrinter) );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("NO SE PUEDO CREAR ARCHIVO.");
			}
		}
		
		return printers;
	}
	
	/*
	 * recorre la lista de CONSOLAS a donde loguear y lanza una instancia por cada consolas
	 * 
	 */
	private ArrayList<Printer> createPrintersConsole(ArrayList<Hashtable<String, String>> printersConsole) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aConsolePrinter : printersConsole){
			printers.add( new ConsolePrinter(aConsolePrinter) );
		}
		
		return printers;
	}
	
	/*
	 *toma el mensaje a loguer y se lo pasa a cada printer para que aplique su respectivo formato y lo vuelque
	 *a su respectiva salida 
	 */
	private boolean log(String aMessage,LogLevel logLevel) {
		message = aMessage;
		
		for (Printer printer : printers){        	        	
        	if(printer.verifyLogLevel(logLevel)){
        		printer.print( aMessage );
        		return true;
        	}
        }
        return false;
	}
	
	public boolean logOff(String message){
		return log(message,LogLevel.OFF);
	}
	
	public boolean logFatal(String message){
		return log(message,LogLevel.FATAL);
	}
	
	public boolean logError(String message){
		return log(message,LogLevel.ERROR);
	}
	
	public boolean logWarn(String message){
		return log(message,LogLevel.WARN);
	}
	
	public boolean logInfo(String message){
		return log(message,LogLevel.INFO);
	}
	
	public boolean logDebug(String message){
		return log(message,LogLevel.DEBUG);
	}   

	/*
	 * cierra todos los archivos, en el caso de las consolas llama al metodo close, pero no hace nada
	 */
	public void close() {
		for (Printer printer : printers){
          	printer.close();
        }	
	}
}
