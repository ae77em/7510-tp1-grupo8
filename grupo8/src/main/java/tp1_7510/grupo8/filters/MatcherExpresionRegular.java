package tp1_7510.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * toma una expresion regular al instanciarse y luego se le pasa un mensaje para que lo teste en funcion del a exp reg
 * antes seteada
 */
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
