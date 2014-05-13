package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurer {
	private Properties prop;
	
	public void loadProperties(){
		prop = new Properties();
		InputStream input = null;
	 
		try {
			input = new FileInputStream("src/main/java/tp1_7510/grupo8/Properties/logger.properties");	 
			// load a properties file
			prop.load(input);
			
			System.out.println(prop);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("HOAHOAHO");
		} 
	}
}
