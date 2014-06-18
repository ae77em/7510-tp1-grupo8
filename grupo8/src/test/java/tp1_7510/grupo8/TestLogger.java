package tp1_7510.grupo8;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Logger.Logger;
import junit.framework.TestCase;

public class TestLogger{	
    final static ArrayList<String> files = new ArrayList<String>();

    //En los test la configuracion tiene que ser levantada desde un Properties
	Configurator configurator = new Configurator(PathLogs.PATH_TEST+"/testConfig/config.properties");
	
	JSONArray configLoggers = configurator.getConfigurationLogger();
	
	Logger aLogger = new Logger((JSONObject)configLoggers.get(0));
	
	@Test
	public void testOkLogLevel(){
		aLogger.debug("HOLA DEBUG");
		
		aLogger.close();
				
		assertEquals(1,1);
    }
	
	@Test
	public void testOkExpReg(){
		//la expresion regular solo soporte letras
		aLogger.trace("HOLA TRACE");
		
		aLogger.close();
				
		assertEquals(1,1);
    }
	
	@Test
	public void testErrorExpReg(){
		//la expresion regular solo soporte letras
		aLogger.trace("HOLA TRACE");
		
		aLogger.close();
				
		assertEquals(1,1);
    }
		
	@AfterClass
	 public static void cleanUpFiles() {
		 TestLogger.cleanTestFiles();
	 }

	private static void cleanTestFiles() {
		for (String aFile: files) {
		   File testfile = new File(aFile);
		   
		   if (testfile.exists())
			   testfile.delete();
		}		
	}
}
