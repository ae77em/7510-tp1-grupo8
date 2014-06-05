package tp1_7510.grupo8;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class TestMatcherExpReg extends TestCase{
	MatcherExpresionRegular matcher;
	
	public void testExpRegOk(){		
		matcher = new MatcherExpresionRegular("^[0-9]*$");
				
		assertEquals(true,matcher.checkFormatMessage("120"));
	}
	
	public void testExpRegFault(){		
		matcher = new MatcherExpresionRegular("^[0-9]*$");
		
		assertEquals(false,matcher.checkFormatMessage("ABC"));
	}

}
