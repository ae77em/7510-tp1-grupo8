package tp1_7510.grupo8;

public class ControllerMessage {
	String errorMessage;
	Level level;
	MatcherExpresionRegular matcherExpReg;

	//debe recibir nivel de log de logger, exp reg, y custom filter
	public ControllerMessage(LogLevel aLogLevel,String patternExpReg){		
		level = new Level(aLogLevel);
		matcherExpReg = new MatcherExpresionRegular(patternExpReg);
	}
	
	public boolean isMessageOk(String aMessage,LogLevel aLogLevel) {
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
		
		/*if (CU){ CONTROLAR POR FILTRO CUSTOM
			
		}*/
		
		return statusMessage;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
