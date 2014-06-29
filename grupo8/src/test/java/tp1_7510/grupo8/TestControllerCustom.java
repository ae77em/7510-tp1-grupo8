package tp1_7510.grupo8;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1_7510.grupo8.Patterns.PatternLineNumber;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;

public class TestControllerCustom {
	PatternSimpleMessage simpleText = new PatternSimpleMessage();
	PatternLineNumber lineNumber = new PatternLineNumber();
	
	FilterCustom aFilterCustom1 = new FilterCustom("^[a-zA-ZÒ—]*$",simpleText);
	FilterCustom aFilterCustom2 = new FilterCustom("^[02468]*$",lineNumber);
	
	ControllerCustom controllerCustom = new ControllerCustom();
	
	@Test
	public void testValidateOk(){
		simpleText.setText("HOLA");
		lineNumber.setLine(2);
		
		controllerCustom.addFilterCustom(aFilterCustom1);
		controllerCustom.addFilterCustom(aFilterCustom2);
		
		assertEquals(true,controllerCustom.validate());
	}
	
	@Test
	public void testValidateFalse(){
		simpleText.setText("HOLA");
		lineNumber.setLine(1);
		
		controllerCustom.addFilterCustom(aFilterCustom1);
		controllerCustom.addFilterCustom(aFilterCustom2);
		
		assertEquals(false,controllerCustom.validate());
	}

}
