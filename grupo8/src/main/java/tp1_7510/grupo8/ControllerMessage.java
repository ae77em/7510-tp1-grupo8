package tp1_7510.grupo8;

public class ControllerMessage {
	String errorMessage;
	Level level;

	//debe recibir nivel de log de logger, exp reg, y custom filter
	public ControllerMessage(LogLevel aLogLevel){		
		level = new Level(aLogLevel);
	}
	
	public boolean isMessageOk(String aMessage,LogLevel aLogLevel) {
		boolean statusMessage = false;
		errorMessage = "";
		
		if(level.isLowerOrEqual(aLogLevel)){
			statusMessage = true;
		}else{
			errorMessage = "ERROR DE LEVEL"; //DESPUES MEJORAR			
		}
		
		/*if (CU){ CONTROLAR POR FILTRO CUSTOM Y EXPRESION REGULAR
			
		}*/
		
		return statusMessage;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
