package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

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
		
		filterCustom = aFilterCustom;
	}
	
	public boolean isMessageOk(String aMessage,LogLevel aLogLevel, Hashtable<String, Pattern> filtersCustom) {
		boolean statusMessage = true;
		errorMessage = "";
		
		if(!level.isLowerOrEqual(aLogLevel)){
			statusMessage = false;
			
			errorMessage += "ERROR DE LEVEL "; //DESPUES MEJORAR			
		}
		
		if(!matcherExpReg.checkFormatMessage(aMessage)){
			statusMessage = false;
			
			errorMessage += "ERROR DE EXP REG "; //DESPUES MEJORAR			
		}
		
		if(!filtersCustomIsOk(filtersCustom)){
			errorMessage += "ERROR EN FILTER CUSTOM";
			
			statusMessage = false;
		}
			
		
		return statusMessage;
	}

	private boolean filtersCustomIsOk(Hashtable<String, Pattern> aFiltersCustom) {
		
		Set<String> set = filterCustom.keySet(); //obtengo los cod de pattern

	    Iterator<String> itr = set.iterator();
	    
	    while (itr.hasNext()) {
		      String key = itr.next();
		      String expRegular = filterCustom.get(key);
	
		      MatcherExpresionRegular matcherExpRegCustomFilters = new MatcherExpresionRegular(expRegular);
	 
		      String patternAplicatedMessage = aFiltersCustom.get(key).getText();
		      
		      if( !matcherExpRegCustomFilters.checkFormatMessage( patternAplicatedMessage ) )
		    	  return false;
	    }
	    
		// TODO Auto-generated method stub
		return true;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
