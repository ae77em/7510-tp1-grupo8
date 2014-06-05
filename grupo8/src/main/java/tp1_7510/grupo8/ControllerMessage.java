package tp1_7510.grupo8;

import java.util.Hashtable;

import tp1_7510.grupo8.Patterns.Pattern;

public class ControllerMessage {
	String errorMessage;
	Level level;
	MatcherExpresionRegular matcherExpReg;
	Hashtable<String, String> filterCustom; //lo levante del XML

	//debe recibir nivel de log de logger, exp reg, y custom filter
	public ControllerMessage(LogLevel aLogLevel,String patternExpReg, Hashtable<String, String> aFilterCustom){		
		level = new Level(aLogLevel);
		matcherExpReg = new MatcherExpresionRegular(patternExpReg);
		filterCustom = aFilterCustom
	}
	
	public boolean isMessageOk(String aMessage,LogLevel aLogLevel, Hashtable<String, Pattern> filtersCustom) {
		boolean statusMessage = false;
		errorMessage = "";
		
		if(level.isLowerOrEqual(aLogLevel)){
			statusMessage = true;
		}else{
			errorMessage += "ERROR DE LEVEL "; //DESPUES MEJORAR			
		}
		
		if(matcherExpReg.checkFormatMessage(aMessage)){
			statusMessage = true;
		}else{
			errorMessage += "ERROR DE EXP REG "; //DESPUES MEJORAR			
		}
		
		/*if (CU){ 
			
		}*/
		
		return statusMessage;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
