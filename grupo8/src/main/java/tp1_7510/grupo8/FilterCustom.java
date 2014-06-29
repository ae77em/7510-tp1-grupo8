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
		return matcherExpReg.checkFormatMessage(aPattern.getText());
	}

}
