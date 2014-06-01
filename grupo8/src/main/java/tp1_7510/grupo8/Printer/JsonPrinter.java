package tp1_7510.grupo8.Printer;

import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

import org.json.simple.JSONObject;

import tp1_7510.grupo8.Patterns.Pattern;

 
public class JsonPrinter extends Printer {

	private PrintWriter writter;
	private JSONObject 	jsonObject;
		
	public JsonPrinter(Hashtable<String, String> dataConfiguration) throws FileNotFoundException {
		super(dataConfiguration);
		
		writter = new PrintWriter(new FileOutputStream(new File(dataConfiguration.get("name"))));
		jsonObject = new JSONObject();
	}

	public void print(String s) {
		
		for(Pattern aPattern : messagePatterns){
			
			jsonObject.put(aPattern.toString(), aPattern.getText());
		}
				
		writter.println(jsonObject);
	}

	public void close() {
		writter.close();
	}

}
