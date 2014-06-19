package tp1_7510.grupo8.Printer;

import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

import org.json.simple.JSONObject;

import tp1_7510.grupo8.CONSTANTS.PathLogs;
import tp1_7510.grupo8.Patterns.Pattern;

public class JsonPrinter extends Printer {

	private PrintWriter writter;
	private JSONObject 	jsonObject;
		
	public JsonPrinter(Hashtable<String, String> dataConfiguration,Hashtable<String,String> filterCustom) throws FileNotFoundException {
		super(dataConfiguration,filterCustom);
		
		writter = new PrintWriter(new FileOutputStream(new File(PathLogs.PATH_LOG + (String) dataConfiguration.get("name"))));
				
		jsonObject = new JSONObject();
	}

	public void print(String s) {
		for(Pattern aPattern : messagePatterns){	
			jsonObject.put(aPattern.toString(), aPattern.getText());
		}
				
		writter.println(jsonObject.toJSONString());
	}

	public void close() {
		writter.close();
	}

}
