package tp1_7510.grupo8.Printer;

import java.io.*;
import java.util.Hashtable;

import tp1_7510.grupo8.CONSTANTS.PathLogs;

public class FilePrinter extends Printer{

	private FileWriter writter;
	private Hashtable<String, String> dataConfiguration;

	public FilePrinter(Hashtable<String, String> dataConfiguration, Hashtable<String, String> filterCustom) throws FileNotFoundException{
		super(dataConfiguration, filterCustom);
		
		this.dataConfiguration = dataConfiguration;
	}
	

	public void print(String aMessage){
		
		open();
		
		try {
			writter.write(aMessage+System.getProperty("line.separator"));
            System.out.println("Successfully Copied Log to File...");
            System.out.println("Log: " + aMessage);
 
        } catch (IOException e) {
            e.printStackTrace();
 
        }
		
		close();
	}
	
	
	private void open() {
		try {
			writter = new FileWriter(PathLogs.PATH_LOG + (String) dataConfiguration.get("name"),true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	public void close() {
        try {
        	writter.flush();
			writter.close();			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
