package tp1_7510.grupo8;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.TestCase;

public class TestConfigurator extends TestCase{
	
	Configurator configurator = new Configurator("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
			
	public void testGetFiles(){
		String files = configurator.getFiles();
		assertEquals("file2.txt,",files);
	}

	public void testGetConsoles(){		
		String consoles = configurator.getConsoles();
		assertEquals("SUPER_CONSOLA,",consoles);
	}
}