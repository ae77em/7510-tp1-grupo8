package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

public class Configurator {
 	 	
	private Properties properties;

	Configurator(String pathProperties){
		properties = new Properties();
		
		InputStream input = null;
		 
		try {
			input = new FileInputStream(pathProperties);	 
			properties.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFiles() {
		return properties.getProperty("files");
	}
	public String getConsoles() {
		return properties.getProperty("consoles");
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public ArrayList<Hashtable<String, String>> getPrintersConfiguration(String printer) {
		ArrayList<Hashtable<String, String>> printersConfiguration = new ArrayList<Hashtable<String, String>>();
		
		String printers = properties.getProperty(printer);
		
		if(printers.length()<=1){ //si no hay impresoras del tipo seleccionado,CONSOLE O PRINTER
			return printersConfiguration;
		}

		String[] aPrinters = printers.split(","); 
		
		for(int i=0; i<aPrinters.length;i++){
			printersConfiguration.add( getPrinterConfiguration(aPrinters[i]));
		}

		return printersConfiguration;
	}

	public Hashtable<String, String> getPrinterConfiguration(String aPrinter) {
		Hashtable<String, String> dataConfiguration = new Hashtable<String, String>();
		
		dataConfiguration.put("name", aPrinter);
		dataConfiguration.put("separator", properties.getProperty(aPrinter+"-separator"));
		dataConfiguration.put("logLevel", properties.getProperty(aPrinter+"-logLevel"));
		dataConfiguration.put("formatDate", properties.getProperty(aPrinter+"-formatDate"));
		dataConfiguration.put("format", properties.getProperty(aPrinter+"-format"));
						
		return dataConfiguration;
	}
	
	public Hashtable<String, ArrayList<Hashtable<String, String>>> getPrintersConfiguration(){
		Hashtable<String, ArrayList<Hashtable<String, String>>> printers = new Hashtable<String, ArrayList<Hashtable<String, String>>>();
		
		printers.put("FILES", getPrintersConfiguration("files"));
		printers.put("CONSOLES", getPrintersConfiguration("consoles"));
		
		return printers;
	}
}

