package tp1_7510.grupo8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.TestCase;

public class TestLogger extends TestCase{
	
	Configurator configurator = null; 
	Logger logger = null;
	BufferedReader reader = null;
	
	public void testOkLogLevel(){
		//el archivo de prueba posee seteado como salida el archivo file2.txt para loguear
		//el formato de mensaje es %L-%n-%m-%n-%p-%n-%t
		configurator = new Configurator("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
		logger = new Logger( configurator.getPrintersConfiguration() );
		
        logger.logError("MensajeError");
        
        logger.close();
        
        String line = "";
		
		try {
		    reader = new BufferedReader(new FileReader( new File("file2.txt") ) );
		    line = reader.readLine();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("No se pudo abrir archivo para controlar testOkLevel");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	    
		assertEquals(line,"0-MensajeError-ERROR-main");
	}
	
	public void testErrorLogLevelConsole(){
		configurator = new Configurator("src/main/java/tp1_7510/grupo8/Properties/testLoggerConsole.properties");
		logger = new Logger( configurator.getPrintersConfiguration() );
		
        logger.logDebug("MensajeDEBUG");
        
        logger.close();
        
        String line = "";
		
		try {
		    reader = new BufferedReader(new FileReader( new File("error.dat") ) );
		    line = reader.readLine();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("No se pudo abrir archivo para controlar testErrorLevelCONSOLE");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	    
		assertEquals(line,"Error Level en mensaje: MensajeDEBUG LevelPrinter: FATAL LevelMessage: DEBUG");
	}
	
	public void testErrorLogLevelFile(){
		configurator = new Configurator("src/main/java/tp1_7510/grupo8/Properties/testLoggerFile.properties");
		logger = new Logger( configurator.getPrintersConfiguration() );
		
        logger.logDebug("MensajeDEBUG");
        
        logger.close();
        
        String line = "";
		
		try {
		    reader = new BufferedReader(new FileReader( new File("error.dat") ) );
		    line = reader.readLine();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("No se pudo abrir archivo para controlar testErrorLevelFILE");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	    System.out.println(line);
		assertEquals(line,"Error Level en mensaje: MensajeDEBUG LevelPrinter: INFO LevelMessage: DEBUG");
	}
}
