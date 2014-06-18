package tp1_7510.grupo8;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Logger.Logger;

public class TestLogger{	
    final static ArrayList<String> files = new ArrayList<String>();

    //En los test la configuracion tiene que ser levantada desde un archivo Properties
	Configurator configurator = new Configurator(PathLogs.PATH_TEST+"testConfig/config.properties");
	
	JSONArray configLoggers = configurator.getConfigurationLogger();
	
	Logger aLogger = new Logger((JSONObject)configLoggers.get(0));
	
	@Test
	public void testOkLogLevel() throws IOException, InterruptedException{        
		String message = "debug"; 
		
		aLogger.debug(message);
		
		aLogger.close();
				
		assertEquals(getLogMessageMock(message),getMessageFromFile(PathLogs.PATH_LOG + "aFileName1"));
	}
	
	@Test
	public void testErrorLogLevel() throws IOException, InterruptedException{        
		String message = "trace"; 
		
		aLogger.trace(message);
		
		aLogger.close();
				
		assertEquals(getErrorMessageMock(),getMessageFromFile(PathLogs.PATH_ERROR + "error.dat"));
	}
	
	@Test
	public void testOkExpReg() throws InterruptedException, IOException{
		String message = "OKEXPREG"; 
		
		aLogger.debug(message);
		
		aLogger.close();
				
		assertEquals(getLogMessageMock(message),getMessageFromFile(PathLogs.PATH_LOG + "aFileName1"));
    }
	
	@Test
	public void testErrorExpReg() throws IOException{
		String message = "1234"; 
		
		aLogger.debug(message);
		
		aLogger.close();
				
		assertEquals(getErrorExpRegMessageMock(),getMessageFromFile(PathLogs.PATH_ERROR + "error.dat"));
    }

	@Test
	public void testOkFilterCustomP() throws IOException{
		//solo se puede loguear mensaje DEBUG
		String message = "DEBUG"; 
		
		aLogger.debug(message);
		
		aLogger.close();
				
		assertEquals(getLogMessageMock(message),getMessageFromFile(PathLogs.PATH_LOG + "aFileName1"));
    }

	@Test
	public void testErrorFilterCustomP() throws IOException{
		String message = "ERRORmessage"; 
		
		aLogger.error(message);
		
		aLogger.close();
					
		assertEquals(getErrorFilterCustomMessageMock(),getMessageFromFile(PathLogs.PATH_ERROR + "error.dat"));
    }


	@Test
	public void testErrorOkFilterCustomP() throws IOException{
		String message = "aMessage"; 
		
		aLogger.error(message);
		aLogger.debug(message);
		
		aLogger.close();
					
		assertEquals(getErrorFilterCustomMessageMock(),getMessageFromFile(PathLogs.PATH_ERROR + "error.dat"));
		assertEquals(getLogMessageMock(message),getMessageFromFile(PathLogs.PATH_LOG + "aFileName1"));
    }

	private String getErrorFilterCustomMessageMock() {
		return "ERROR FILTER CUSTOM";
	}

	private String getErrorExpRegMessageMock() {
		return "ERROR IN EXP REG";
	}

	private String getErrorMessageMock() {
		return "ERROR LEVEL, level message is: TRACE level Log is: DEBUG";
	}
			
	private String getLogMessageMock(String message) {
		return new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date())+"-DEBUG-main-"+message;
	}

	@AfterClass
	 public static void cleanUpFiles() {
		 TestLogger.cleanTestFiles();
	 }
	
	private String getMessageFromFile(String pathFile) throws IOException{
		files.add(pathFile);//al final de cada test re borran los archivo que hayan sido creados, para eso leo la lista de paths usados

		return new BufferedReader( new FileReader ( new File (pathFile) ) ).readLine();
	}

	private static void cleanTestFiles() {
		for (String aFile: files) {
		   File testfile = new File(aFile);
		   
		   if (testfile.exists())
			   testfile.delete();
		}		
	}
}
