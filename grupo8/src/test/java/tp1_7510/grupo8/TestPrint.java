package tp1_7510.grupo8;

import java.util.Hashtable;

import tp1_7510.grupo8.Printer.*;
import junit.framework.TestCase;

public class TestPrint extends TestCase {

	public void testPrinter(){
		
		Hashtable<String,String> prop = new Hashtable<String,String>();
		prop.put("logLevel", "OFF");
		prop.put("separator", ";");
		prop.put("formatDate", "yyyy/MM/dd");
		prop.put("name", "prueba");
		prop.put("format","%d %L");
		
		Printer p = new Printer(prop);
		
		System.out.println(p.getLogLevel());
		
		assertEquals(LogLevel.OFF, p.getLogLevel());
		/*assertEquals("??", patternSeparatorUD.getText());
		assertEquals("=-", patternSeparator.addText("="));
		assertEquals("AAA??", patternSeparatorUD.addText("AAA"));*/
	}
}
