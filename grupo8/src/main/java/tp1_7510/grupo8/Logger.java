package tp1_7510.grupo8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	public static String message = "";
	private ArrayList<Printer> printers = new ArrayList<Printer>();
	
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> dataConfiguration){
		
		printers.addAll( createPrintersConsole(dataConfiguration.get("CONSOLES")));
		printers.addAll( createPrintersFile(dataConfiguration.get("FILES")));
	}
	
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
	
	private ArrayList<Printer> createPrintersConsole(ArrayList<Hashtable<String, String>> printersConsole) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aConsolePrinter : printersConsole){
			printers.add( new ConsolePrinter(aConsolePrinter) );
		}
		
		return printers;
	}
	
	private void log(String aMessage,LogLevel logLevel) {
		message = aMessage;
		Level level = new Level(logLevel);
		
		for (Printer printer : printers){        	        	
        	if(level.isLowerOrEqual(printer.getLogLevel())){
        		printer.print( aMessage );
        	}else{
        		System.out.println("ERROR EN MENSAJE "+message+" NIVEL: "+printer.getLogLevel());
        	}
        }
	}
	
	public void logOff(String message){
		log(message,LogLevel.OFF);
	}
	
	public void logFatal(String message){
		log(message,LogLevel.FATAL);
	}
	
	public void logError(String message){
		log(message,LogLevel.ERROR);
	}
	
	public void logWarn(String message){
		log(message,LogLevel.WARN);
	}
	
	public void logInfo(String message){
		log(message,LogLevel.INFO);
	}
	
	public void logDebug(String message){
		log(message,LogLevel.DEBUG);
	}   

	public void close() {
		for (Printer printer : printers){
          	printer.close();
        }	
	}
}
