package tp1_7510.grupo8;

import java.util.Hashtable;

import tp1_7510.grupo8.Printer.*;
import junit.framework.TestCase;

public class TestPrint extends TestCase {

	public void testPrinter(){
		
		Hashtable<String, String> prop = new Hashtable<String, String>();
		prop.put("logLevel", LogLevel.ERROR.toString());
		prop.put("separator", ";");
		prop.put("formatDate", "yyyy/MM/dd");
		prop.put("name", "prueba");
		prop.put("format","%L-%n-%d{HH:mm:ss}-%n-%p-%n-%m");
		
		Printer p = new ConsolePrinter(prop);
				
		assertEquals(LogLevel.ERROR, p.getLogLevel());
		assertFalse(LogLevel.FATAL == p.getLogLevel());
	}
}