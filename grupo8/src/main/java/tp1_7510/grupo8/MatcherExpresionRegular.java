package tp1_7510.grupo8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherExpresionRegular {
	Pattern pattern; 
	Matcher matcher;
	
	public MatcherExpresionRegular(String patternExpReg) {
		pattern = Pattern.compile(patternExpReg);
	}

	public boolean checkFormatMessage(String aMessage) {
		matcher = pattern.matcher(aMessage);

		return matcher.find();
	}
	
	

}
