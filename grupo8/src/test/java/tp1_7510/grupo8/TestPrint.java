package tp1_7510.grupo8;

import java.util.Hashtable;

import tp1_7510.grupo8.Printer.*;
import junit.framework.TestCase;

public class TestPrint extends TestCase {

	public void testPrinter(){
		
		Hashtable<String,Object> prop = new Hashtable<String,Object>();
		prop.put("logLevel", LogLevel.ERROR);
		prop.put("separator", ";");
		prop.put("formatDate", "yyyy/MM/dd");
		prop.put("name", "prueba");
		prop.put("format","%L-%n-%d{HH:mm:ss}-%n-%p-%n-%m");
		
		Printer p = new Printer(prop);
				
		assertEquals(LogLevel.ERROR, p.getLogLevel());				
	}
}
