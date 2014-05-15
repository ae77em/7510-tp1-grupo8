package tp1_7510.grupo8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.FilePrinter;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	private ArrayList<Printer> m_Printers = new ArrayList<Printer>();
	
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> dataConfiguration){
		/*quedatio mejor pregunta si contiene algun printer cada hash*/
	//System.out.println("CONSOLES");
		m_Printers.addAll( createPrintersConsole(dataConfiguration.get("CONSOLES")) );
		//System.out.println("FILES");
		m_Printers.addAll( createPrintersFile(dataConfiguration.get("FILES")) );
	}
	
	private ArrayList<Printer> createPrintersFile(ArrayList<Hashtable<String,String>> printersFiles) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aFilePrinter : printersFiles){
		    try {
				printers.add( new FilePrinter(aFilePrinter) );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("NO SE PUEDO CREAR ARHICO");
			}
		}
		
		return printers;
	}

	private ArrayList<Printer> createPrintersConsole(ArrayList<Hashtable<String, String>> printersConsole) {
		ArrayList<Printer> printers = new ArrayList<Printer>();
		
		for(Hashtable<String, String> aConsolePrinter : printersConsole){
			printers.add( new ConsolePrinter(aConsolePrinter) );
		    //System.out.println(aConsolePrinter);
		}
		
		return printers;
	}

	public void log(String message) {        
        for (int i = 0; i < m_Printers.size(); i++){
          	m_Printers.get(i).print( message );
        }
	}

	public void close() {
		for (int i = 0; i < m_Printers.size(); i++){
          	m_Printers.get(i).close();
        }	
	}
}
