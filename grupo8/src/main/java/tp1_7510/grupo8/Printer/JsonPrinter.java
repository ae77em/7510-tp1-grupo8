package tp1_7510.grupo8.Printer;

import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Patterns.Pattern;

public class JsonPrinter extends Printer {

	private FileWriter writter;
	private JSONObject 	jsonObject;
	private Hashtable<String, String> dataConfiguration;
		
	public JsonPrinter(Hashtable<String, String> dataConfiguration, Hashtable<String, String> filterCustom) throws FileNotFoundException {
		super(dataConfiguration,filterCustom);
		
		this.dataConfiguration = dataConfiguration;
						
		jsonObject = new JSONObject();
	}

	public void print(String s) {
				
		openJsonFile();
		
		for(Pattern aPattern : messagePatterns){	
			jsonObject.put(aPattern.toString(), aPattern.getText());
		}
		
		writeJsonFile(jsonObject.toJSONString());
		close();
	}

	private void writeJsonFile(String output) {
		try {
			writter.write(output+System.getProperty("line.separator"));
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("JSON Object: " + output);
 
        } catch (IOException e) {
            e.printStackTrace();
 
        }
	}

	private void openJsonFile() {
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
