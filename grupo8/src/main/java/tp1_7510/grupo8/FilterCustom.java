package tp1_7510.grupo8;

import tp1_7510.grupo8.Patterns.Pattern;

public class FilterCustom {
	Pattern aPattern;
	MatcherExpresionRegular matcherExpReg;

	public FilterCustom(String expReg, Pattern pattern) {
		aPattern = pattern;
		matcherExpReg = new MatcherExpresionRegular(expReg);
	}

	public boolean validate() {
		System.out.println("VAL: " + aPattern.getText() + " WITH " + matcherExpReg.getExpReg());
		return matcherExpReg.checkFormatMessage(aPattern.getText());
	}

}
