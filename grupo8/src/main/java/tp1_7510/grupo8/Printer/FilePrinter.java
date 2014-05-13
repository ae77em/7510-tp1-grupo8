package tp1_7510.grupo8.Printer;

import java.io.*;

public class FilePrinter implements Printer 
{
	private PrintWriter m_Writter;
	
	FilePrinter(String filename) throws FileNotFoundException{
		m_Writter = new PrintWriter(new FileOutputStream(new File(filename),true /* append = true */)); 
	}
	
	public void print(String message){
		m_Writter.println(message);
	}
}
