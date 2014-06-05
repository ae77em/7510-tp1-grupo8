package tp1_7510.grupo8.Printer;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.ControllerMessage;
import tp1_7510.grupo8.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;

public abstract class Printer {
	
	protected ArrayList<Pattern> messagePatterns;
	protected Hashtable<String,Pattern> filtersCustom;
	protected FactoryPatterns factoryPatterns;
	
	LogLevel logLevel;
	ControllerMessage controllerMessage;
	
	public Printer(Hashtable<String, String> dataConfiguration,Hashtable<String,String> filterCustom){
		factoryPatterns = new FactoryPatterns(dataConfiguration);
		
		factoryPatterns.buildPatterns();
		
		messagePatterns = factoryPatterns.getListOfPatterns();
		
		filtersCustom = factoryPatterns.getFilterCustomOfPatterns();
		
		setLogLevel(LogLevel.valueOf((String) dataConfiguration.get("logLevel")));
		
		//TOMAR DE DATA-CONFIGURATION UN HASH O JSON QUE CONTENGA EL FILTER CUSTOM DEL XML Y PASARSELO A CONTROLLER MESSAGE
		
		Hashtable<String, String> aFilterCustom = new Hashtable<String, String>();
		aFilterCustom.put("%p", "DEBUG");
		aFilterCustom.put("%L", "1");
		
		controllerMessage = new ControllerMessage(null,"patterExpReg",aFilterCustom); //ACTUALIZAR CUANDO SE DEFINA EL XML O PROPERTIES
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
	
	private void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
	}

	public abstract void print(String s);

	public abstract void close();

	public boolean isMessageOk(String aMessage, LogLevel aLogLevel) {
		return controllerMessage.isMessageOk(aMessage,aLogLevel,filtersCustom);
	}

	public String getErrorMessage() {
		return controllerMessage.getErrorMessage();
	}
}
