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
	public void loadDefaultProperties(){
		prop.setProperty("files","");
		prop.setProperty("consoles","consoleDefault");	
		prop.setProperty("consoleDefault-separator", "-");
		prop.setProperty("consoleDefault-logLevel", "DEBUG");
		prop.setProperty("consoleDefault-formatDate", "%d{HH:mm:ss}");
		prop.setProperty("consoleDefault-format", "%d{HH:mm:ss}-%p-%t-%m");
	}
	
	public String getConsoles() {
		// TODO Auto-generated method stub
		return prop.getProperty("consoles");
	}
	
	public String getFiles() {
		// TODO Auto-generated method stub
		return prop.getProperty("files");
	}
	
	public void createFile(String aFile) {
		String files = prop.getProperty("files");
		
		files += aFile + ","; 
		
		prop.setProperty("files",files);
		
		createDefaultsSetting(aFile);
	}
	
	private void createDefaultsSetting(String aPrinter) {
		prop.setProperty(aPrinter+"-separator", "-");
		prop.setProperty(aPrinter+"-logLevel", "DEBUG");
		prop.setProperty(aPrinter+"-formatDate", "%d{HH:mm:ss}");
		prop.setProperty(aPrinter+"-format", "%d{HH:mm:ss}-%p-%t-%m");
	}

	public void createConsole(String aConsole) {
		if(prop.getProperty("consoles") == "consoleDefault"){
			eraseDefaultConfiguration();
		}
		
		String consoles = prop.getProperty("consoles");
		
		consoles += aConsole + ","; 
		
		prop.setProperty("consoles",consoles);	
	}

	private void eraseDefaultConfiguration() {
		prop.setProperty("consoles","");		
		prop.remove("consoleDefault-separator");
		prop.remove("consoleDefault-logLevel");
		prop.remove("consoleDefault-formatDate");
		prop.remove("consoleDefault-format");
	}

	/**************SETTERS*************************/
	public void setFormatDate(String aPrinter, String formatDate){
		prop.setProperty(aPrinter+"-formatDate", formatDate);
	}
	
	public void setFormatMessage(String aPrinter, String formatMessage){
		prop.setProperty(aPrinter+"-format", formatMessage);
	}
	
	public void setLogLevel(String aPrinter, String logLevel){
		prop.setProperty(aPrinter+"-logLevel", logLevel);
	}
	
	public void setSeparator(String aPrinter, String separator){
		prop.setProperty(aPrinter+"-separator", separator);
	}
	
	/**************GETTERS*************************/
	public Properties getProperties(){
		return prop;
	}
	
	public String getFormatDate(String aPrinter){
		return prop.getProperty(aPrinter+"-formatDate");
	}
	
	public String getFormatMessage(String aPrinter){
		return prop.getProperty(aPrinter+"-format");
	}
	
	public String getLogLevel1(String aPrinter){
		return prop.getProperty(aPrinter+"-logLevel");
	}
	
	public String getSeparator(String aPrinter){
		return prop.getProperty(aPrinter+"-separator");
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

	public String getLogLevel(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

