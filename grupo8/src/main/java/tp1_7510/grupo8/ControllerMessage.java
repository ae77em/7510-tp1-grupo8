package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import tp1_7510.grupo8.Logger.LogLevel;
import tp1_7510.grupo8.Patterns.Pattern;

public class ControllerMessage {
	String errorMessage;

	Level level;
	MatcherExpresionRegular matcherExpReg;
	Hashtable<String, String> filterCustom; 

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
			
			errorMessage += "ERROR LEVEL, level message is: "+aLogLevel.toString() + " level Log is: "+level.getLogLevel().toString(); 			
		}
		
		if(!matcherExpReg.checkFormatMessage(aMessage)){
			statusMessage = false;
			
			errorMessage += "ERROR IN EXP REG "; //DESPUES MEJORAR			
		}
		
		if(!filtersCustomIsOk(filtersCustom)){
			errorMessage += "ERROR IN FILTER CUSTOM";
			
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
		   
		      String patternAplicatedMessage = aFiltersCustom.get(key).getText();

		      MatcherExpresionRegular matcherExpRegCustomFilters = new MatcherExpresionRegular(expRegular);
	 	      
		      if( !matcherExpRegCustomFilters.checkFormatMessage( patternAplicatedMessage ) ){
		    	  System.out.print("NO ANDUVO CON   ");
		    	  System.out.print(key+"   ");
			      System.out.print(patternAplicatedMessage+"   ");
			      System.out.println(expRegular);
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
