package tp1_7510.grupo8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	public static String message = ""; //variable que contendra el mensaje del logueo
	
	private ArrayList<Printer> m_Printers = new ArrayList<Printer>(); //lista que contendra todas las clases que impriman mensajes
	
	/*
	 * El constructor toma un hash con las consolas y los archivos a donde loguear los mensajes
	 * cada item de las lista contiene un hash que tiene la configuracion de cada LOG
	 * */
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> dataConfiguration){
		
		m_Printers.addAll( createPrintersConsole(dataConfiguration.get("CONSOLES")));

		m_Printers.addAll( createPrintersFile(dataConfiguration.get("FILES")));
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
	public void log(String aMessage,LogLevel levelLog) {
		message = aMessage;
		
        for (int i = 0; i < m_Printers.size(); i++){
        	Printer aPrinter = m_Printers.get(i);
        	
        	if(aPrinter.verifyLogLevel(levelLog)){
        		aPrinter.print( aMessage );
        	}else{
        		System.out.println("NO SE PUEDO ESCRIBIR EL LOG.");
        	}
        }
	}

	/*
	 * cierra todos los archivos, en el caso de las consolas llama al metodo close, pero no hace nada
	 */
	public void close() {
		for (int i = 0; i < m_Printers.size(); i++){
          	m_Printers.get(i).close();
        }	
	}
}
