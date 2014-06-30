package tp1_7510.grupo8;

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
		System.out.println("EXPr: "+ patternExpReg);
		pattern = Pattern.compile(patternExpReg);
	}

	public boolean checkFormatMessage(String aMessage) {
		matcher = pattern.matcher(aMessage);

		return matcher.find();
	}

	public String getExpReg() {
		// TODO Auto-generated method stub
		return pattern.toString();
	}
	
	

}
