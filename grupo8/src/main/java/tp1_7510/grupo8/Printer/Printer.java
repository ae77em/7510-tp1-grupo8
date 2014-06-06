package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.ControllerMessage;
import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;

public abstract class Printer {
	
	protected ArrayList<Pattern> messagePatterns;
	protected Hashtable<String,Pattern> patternsAplicatedToMessage;
	protected FactoryPatterns factoryPatterns;
	
	ControllerMessage controllerMessage;
	
	public Printer(Hashtable<String, String> dataConfiguration,Hashtable<String,String> filterCustomConfig){
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		factoryPatterns.buildPatterns();
		
		messagePatterns = factoryPatterns.getListOfPatterns();
		
		patternsAplicatedToMessage = factoryPatterns.getFilterCustomOfPatterns();
				
		controllerMessage = new ControllerMessage(LogLevel.valueOf((String) dataConfiguration.get("logLevel"))
				,dataConfiguration.get("regularExpresion"),filterCustomConfig); //ACTUALIZAR CUANDO SE DEFINA EL XML O PROPERTIES
	}
	
	public abstract void print(String s);

	public abstract void close();

	public boolean isMessageOk(String aMessage, LogLevel aLogLevel) {
		return controllerMessage.isMessageOk(aMessage,aLogLevel,patternsAplicatedToMessage);
	}

	public String getErrorMessage() {
		return controllerMessage.getErrorMessage();
	}
	
	public String formatMessage(){
		String messageFormated = "";

		for(Pattern aPattern : messagePatterns){
			messageFormated = aPattern.addText(messageFormated);
		}

		return messageFormated;
	}
}
