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
			System.out.println("voy a levantar el archivo");
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
		return properties.getProperty(LogOutput.FILES.toString());
	}
	public String getConsoles() {
		return properties.getProperty(LogOutput.CONSOLES.toString());
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public ArrayList<Hashtable<String, String>> getPrintersConfiguration(LogOutput logOutput) {
		
		ArrayList<Hashtable<String, String>> printersConfiguration = new ArrayList<Hashtable<String, String>>();
		String printersFromProperties = "";
		String[] printers;
		
		printersFromProperties += properties.getProperty(logOutput.toString());
				
		if ( printersFromProperties.equals("null")){ 
			return printersConfiguration;
		}

		printers = printersFromProperties.split(","); 
		
		for(String printer : printers){
			printersConfiguration.add( getPrinterConfiguration(LogOutput.valueOf(printer)));
		}

		return printersConfiguration;
	}

	public Hashtable<String, String> getPrinterConfiguration(LogOutput logOutput) {
		
		String aPrinter = logOutput.toString();
		
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
		
		printers.put(LogOutput.FILES.toString(), getPrintersConfiguration(LogOutput.FILES));
		printers.put(LogOutput.CONSOLES.toString(), getPrintersConfiguration(LogOutput.CONSOLES));
		
		return printers;
	}
}

