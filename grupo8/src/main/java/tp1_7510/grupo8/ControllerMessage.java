package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import tp1_7510.grupo8.Logger.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;

public class ControllerMessage {
	String errorMessage;

	LogLevel level;
	MatcherExpresionRegular matcherExpReg;
	Hashtable<String, String> filterCustom; 
	/*
	 * clase que se encarga de testear que el mensaje a loguear cumpla con el nivel de log, expresion regular
	 * y filter custom de cada Logger
	 */
	public ControllerMessage(LogLevel aLogLevel,String patternExpReg, Hashtable<String, String> aFilterCustom){		
		level = LogLevel.getLogLevel(aLogLevel);
		
		matcherExpReg = new MatcherExpresionRegular(patternExpReg);
		
		filterCustom = aFilterCustom;
	}
	
	/*
	 * metodo que controlar level, exp reg y filter custom
	 */
	public boolean isMessageOk(String aMessage,LogLevel aLogLevel, Hashtable<String, Pattern> filtersCustom) {
		errorMessage = "";
		
		if(!level.isLowerOrEqual(aLogLevel)){
			errorMessage = "ERROR LEVEL, level message is: "+aLogLevel.toString() + " level Log is: "+level.getLogLevel().toString();
			return false;
		}
		
		if(!matcherExpReg.checkFormatMessage(aMessage)){
			errorMessage = "ERROR IN EXP REG"; 
			return false;
		}
		
		if(!filtersCustomIsOk(filtersCustom)){
			errorMessage = "ERROR FILTER CUSTOM";	
			return false;
		}
		
		return true;
	}
	
	/*Se trabaja con el hash de filter custom y el hash de pattern aplicados, ambas tienen apareados las claves
	 * se recorre por las claves de uno de ellos y se toma de uno el mensaje formateado y del otro el patron a aplicar sobre el mismo
	 * luego se insntancia la clase MatcherExpresionRegular con el filtes custom a probar y luego se testeas que el mensaje
	 * transformado cumpla con filter custom
	 */
	private boolean filtersCustomIsOk(Hashtable<String, Pattern> aFiltersCustom) {
		Set<String> set = filterCustom.keySet(); //obtengo los cod de pattern

	    Iterator<String> itr = set.iterator();
	    
	    while (itr.hasNext()) {
		      String key = itr.next();
		      
		      String expRegular = filterCustom.get(key);
		      
		      //obtengo el pattern aplicado sobre el mensaje
		      String patternAplicatedMessage = aFiltersCustom.get(key).getText();
		      //controlo que el resultado del pattenr aplicado cumpla con el filtro defenido en la configuracion
		      MatcherExpresionRegular matcherExpRegCustomFilters = new MatcherExpresionRegular(expRegular);
	 	      
		      if( !matcherExpRegCustomFilters.checkFormatMessage( patternAplicatedMessage ) ){
		    	  return false;
		      }
	    }
		return true;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
