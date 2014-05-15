package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import tp1_7510.grupo8.Patterns.*;

public class Configurer {
 	 	
	private Properties prop;
	
	//-----------------------------------------------
	Configurer(){
		prop = new Properties();
		
		loadDefaultProperties();
	}

	//-----------------------------------------------
	private void loadDefaultProperties(){
		prop.setProperty("separator", "-");
		prop.setProperty("logLevel", "DEBUG");
		prop.setProperty("formatDate", "%d{HH:mm:ss}");
		prop.setProperty("format", "%d{HH:mm:ss}-%p-%t-%m");
	}

	/**************SETTERS*************************/
	public void setFormatDate(String formatDate){
		prop.setProperty("formatDate", formatDate);
	}
	
	public void setFormatMessage(String formatMessage){
		prop.setProperty("format", formatMessage);
	}
	
	public void setLogLevel(String logLevel){
		prop.setProperty("logLevel", logLevel);
	}
	
	public void setSeparator(String separator){
		prop.setProperty("separator", separator);
	}
	
	/**************GETTERS*************************/
	public String getFormatDate(){
		return prop.getProperty("formatDate");
	}
	
	public String getFormatMessage(){
		return prop.getProperty("format");
	}
	
	public String getLogLevel(){
		return prop.getProperty("logLevel");
	}
	
	public String getSeparator(){
		return prop.getProperty("separator");
	}
	
	//-----------------------------------------------
	/*INI ACCESO A DISCO**/
	public void saveProperties(){
		OutputStream output = null;
	 
		try {
			output = new FileOutputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
			 
			prop.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	//-----------------------------------------------
	public void loadProperties(){
		InputStream input = null;
	 
		try {
			input = new FileInputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");	 
			// load a properties file
			prop.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	/*FIN ACCESO A DISCO**/
}

