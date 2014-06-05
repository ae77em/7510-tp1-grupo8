package tp1_7510.grupo8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import junit.framework.TestCase;

public class TestLogger extends TestCase{
	
	Configurator configurator = new Configurator();

	JSONObject configLoggers = configurator.getConfigurationLogger();

	JSONArray jsonArrayConfigLoggers = (JSONArray) configLoggers.get("loggers");
	
	Logger logger = new Logger( (JSONObject) jsonArrayConfigLoggers.get(0) );

	BufferedReader reader = null;
	
	public void testOkLogLevel(){
		//el archivo de prueba posee seteado como salida el archivo file2.txt para loguear
		//el formato de mensaje es %L-%n-%m-%n-%p-%n-%t
        logger.logError("MensajeError");
        
        logger.close();
        
        String line = "";
		
		try {
		    reader = new BufferedReader(new FileReader( new File(PathLogs.PATH_LOG+"parserLog.log") ) );
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
	    
		assertEquals(line,"0-5/6/2014-LogParser-ERROR-MensajeError");
	}

}
