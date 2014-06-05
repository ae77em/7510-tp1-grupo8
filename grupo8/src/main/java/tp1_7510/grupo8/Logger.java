package tp1_7510.grupo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.Exception;

import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	PrintWriter errorWriter;
	
	public static String message = "";
	
	private ArrayList<Printer> printers = new ArrayList<Printer>();
	
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> dataConfiguration){
		
		try {
			errorWriter = new PrintWriter( new File ("error.dat" ) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printers.addAll( createPrintersConsole(dataConfiguration.get(LogOutput.CONSOLES.toString())));
		printers.addAll( createPrintersFile(dataConfiguration.get(LogOutput.FILES.toString())));
	}
	
	private ArrayList<Printer> createPrintersFile(ArrayList<Hashtable<String,String>> printersFiles) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aFilePrinter : printersFiles){
		    try {
				printers.add( new FilePrinter(aFilePrinter) );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("NO SE PUEDO CREAR IMPRESORA.");
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
	
	private void log(String aMessage,LogLevel aLogLevel) {
		message = aMessage;
				
		for (Printer printer : printers){        	        	
        	if(printer.isMessageOk(aMessage,aLogLevel)){
        		printer.print( aMessage );
        	}else{
        		errorWriter.println(printer.getErrorMessage());
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
	
	public void logTrace(String message){
		log(message,LogLevel.TRACE);
	}	
	
	public void logOff(String message, Exception ex){
		try {
			log(message,LogLevel.OFF);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void logFatal(String message, Exception ex){
		try {
			log(message,LogLevel.FATAL);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logError(String message, Exception ex){
		try {
			log(message,LogLevel.ERROR);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logWarn(String message, Exception ex){
		try {
			log(message,LogLevel.WARN);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logInfo(String message, Exception ex){
		try {
			log(message,LogLevel.INFO);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logDebug(String message, Exception ex){
		try {
			log(message,LogLevel.DEBUG);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void logTrace(String message, Exception ex){
		try {
			log(message,LogLevel.TRACE);
		} catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}

	public void close() {
		for (Printer printer : printers){
          	printer.close();
        }
		errorWriter.close ();
	}	
}
