package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Logger;

public class PatternUserDefinedMessage implements Pattern {

	public PatternUserDefinedMessage() {
		
	}
	
	public String addText(String s) {
		return s + Logger.message;
	}

	public String getText() {
		return Logger.message;
	}
	
	public String toString(){
		return "userDefinedMessage";
	}
}
