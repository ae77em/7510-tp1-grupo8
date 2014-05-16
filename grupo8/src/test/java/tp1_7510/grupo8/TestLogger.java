package tp1_7510.grupo8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

public class TestLogger extends TestCase {
	//EN EL CASO DE HABER ERROES SE LOGUEA EL error al archivo erroe.
	public void testOkLogMessage(){ //a causa de nivel de mensaje
		String messageError = "";
		String lineaArchivo = "";
		Configurer configurer = new Configurer();

		configurer.createPrinter("files","file4.txt");
		configurer.setLogLevel("file4.txt","DEBUG");
		configurer.eraseDefaultConsole();
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );	
		
		loguer.log("Mensaje1",LogLevel.FATAL);
		
		loguer.close();
		
		try {
			lineaArchivo = new BufferedReader( new FileReader ( new File ("error.dat") ) ).readLine();
			if (lineaArchivo==null) lineaArchivo ="";
			//si devuelve null es poque es archivo estaba vacio,
			//si el archivo esta vacio es porque no se registraron errores
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(lineaArchivo,messageError);
	};

	//se configura la impresora para imprimir mensajes de nivel FATAL, pero se intenta logear un DEBUG
	public void testErrorLogMessage(){ //a causa de nivel de mensaje
		String messageError = "Error in Printer: file4.txtlevelPrinter: FATAL levelMessage DEBUG";
		String lineaArchivo = "";
		Configurer configurer = new Configurer();

		configurer.createPrinter("files","file4.txt");
		configurer.setLogLevel("file4.txt","FATAL");
		configurer.eraseDefaultConsole();
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );	
		
		loguer.log("Mensaje1",LogLevel.DEBUG);
		
		loguer.close();
		
		try {
			lineaArchivo = new BufferedReader( new FileReader ( new File ("error.dat") ) ).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(lineaArchivo,messageError);
	};
}
