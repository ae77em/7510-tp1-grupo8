package tp1_7510.grupo8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurer {
 
	 /**
	  * Configura el logger desde un archivo properties.
	  */
	 public void configureFromProperties() {
		 try {			 
	   		Properties propiedades = new Properties();
			    
			propiedades.load(new FileInputStream("src/main/java/properties/logger.properties"));
			 
			String format = propiedades.getProperty("format");
			String level = propiedades.getProperty("level");
			
			System.out.println("Formato: "+format+ "\n" +"Nivel: "+ level);
	
	 	} catch (FileNotFoundException e) {
 			System.out.println("Error, el archivo de propiedades no existe.");
 		} catch (IOException e) {
			System.out.println("Error, no se puede leer el archivo");
 		}
 	}
}

