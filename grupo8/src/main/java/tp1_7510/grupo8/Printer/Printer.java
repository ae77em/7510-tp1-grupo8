package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.filters.ControllerCustom;
import tp1_7510.grupo8.CONSTANTS.LogLevel;
import tp1_7510.grupo8.Logger.ControllerMessage;
import tp1_7510.grupo8.Patterns.FactoryPatterns;
import tp1_7510.grupo8.Patterns.Pattern;
import tp1_7510.grupo8.Patterns.PatternSeparator;

public abstract class Printer {
	protected ArrayList<Pattern> messagePatterns;
	protected ControllerCustom controllerCustom;
	protected FactoryPatterns factoryPatterns;
	
	ControllerMessage controllerMessage;
	
	public abstract void print(String s);

	public abstract void close();
	
	public Printer(Hashtable<String, String> dataConfiguration, Hashtable<String, String> aFiltersCustom){
		factoryPatterns = new FactoryPatterns(dataConfiguration,aFiltersCustom);
		
		factoryPatterns.buildPatterns();
		
		messagePatterns = factoryPatterns.getListOfPatterns();
		
		controllerCustom = factoryPatterns.getFilterCustomOfPatterns();
				
		controllerMessage = new ControllerMessage(LogLevel.valueOf((String) dataConfiguration.get("logLevel"))
				,dataConfiguration.get("regularExpresion"),controllerCustom);
	}
	
	

	public boolean isMessageOk(String aMessage, LogLevel aLogLevel) {
		return controllerMessage.isMessageOk(aMessage,aLogLevel);
	}

	public String getErrorMessage() {
		return controllerMessage.getErrorMessage();
	}
	
	public String formatMessage(){
		String messageFormated = "";
		
		try {
			String separator = getSeparator();
			
			for(Pattern aPattern : messagePatterns){
				messageFormated = aPattern.addText(messageFormated)+separator;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	

		return messageFormated;
	}

	private String getSeparator() {
		String separator=" ";
		int i = 0;
				
		while (messagePatterns.get(i).getClass() != PatternSeparator.class 
				&& i < messagePatterns.size() )
			i++;
		
		if ( i < messagePatterns.size() )
			separator = messagePatterns.get(i).getText();
		return separator;
	}
}
