package tp1_7510.grupo8;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Logger.Logger;
import tp1_7510.grupo8.Printer.ConsolePrinter;
import tp1_7510.grupo8.Printer.JsonPrinter;

public class TestJsonPrinter {

	Configurator configurator = new Configurator(PathLogs.PATH_TEST+"testConfig/configJson.properties");
		
	JSONObject jsonConfig = (JSONObject)configurator.getConfigurationLogger().get(0);
		
	Logger aLogger = new Logger(jsonConfig);
	
	  @Test
	  public void testPrintJsonTest() throws IOException{
		
		String message = "errorMessage"; 
			
		aLogger.error(message);
			
		aLogger.close();
				
		assertEquals(getLogMessageMock(message),getMessageFromFile(PathLogs.PATH_LOG + "aJsonName1"));
	  }
	  
	  private String getMessageFromFile(String pathFile) throws IOException{
			return new BufferedReader( new FileReader ( new File (pathFile) ) ).readLine();
	  }

	  private String getLogMessageMock(String message) {
		 String mesAux = "{\"userDefinedMessage\":\""+message+"\",\"logLevel\":\"ERROR\"" + ",\"thread\":\"main\"" + ",\"datetime\":\"";
		 String time = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date()); 
		 mesAux += time + "\",\"separator\":\"-\"}";
	
   		 return mesAux; 
	  }
}
