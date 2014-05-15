package tp1_7510.grupo8;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase{
	
	private Configurer configurer = new Configurer();
	
	public void testLoadDefaultSettinsConfigurer(){
		String prop = "{console-logLevel=DEBUG, console-separator=-, console-format=%d{HH:mm:ss}-%p-%t-%m, console-formatDate=%d{HH:mm:ss}, printers=console}";

		configurer.loadDefaultProperties();

		assertEquals( prop , configurer.getProperties().toString() );		
	}
}
