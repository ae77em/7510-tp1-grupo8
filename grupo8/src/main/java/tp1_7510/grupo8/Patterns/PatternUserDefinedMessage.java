package tp1_7510.grupo8.Patterns;

import tp1_7510.grupo8.Logger.Logger;

public class PatternUserDefinedMessage implements Pattern {
	public PatternUserDefinedMessage() {
	}
	
	public String addText(String s) {
		System.out.println("Aplciando: " + Logger.message);
		return s + Logger.message;
	}

	public String getText() {
		return Logger.message;
	}
	
	public String toString(){
		return "userDefinedMessage";
	}
}
