package tp1_7510.grupo8;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1_7510.filters.FilterCustom;
import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternSimpleMessage;

public class TestFilterCustom {

	PatternSimpleMessage aPattern = new PatternSimpleMessage();
	FilterCustom aFilterCustom = new FilterCustom("^[0-9]*$",aPattern);
	
	@Test
	public void testValidateOk(){
		aPattern.setText("123321");
		assertEquals(true,aFilterCustom.validate());
	}
	
	@Test
	public void testValidateFalse(){
		aPattern.setText("MENSAJE SIN NUMEROS");
		assertEquals(false,aFilterCustom.validate());
	}

}
