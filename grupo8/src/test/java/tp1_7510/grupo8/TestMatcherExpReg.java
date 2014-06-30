package tp1_7510.grupo8;

import tp1_7510.filters.MatcherExpresionRegular;
import junit.framework.TestCase;

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
