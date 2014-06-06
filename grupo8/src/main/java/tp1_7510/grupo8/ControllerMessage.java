package tp1_7510.grupo8;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import tp1_7510.grupo8.Patterns.Pattern;

/*
 * clase que se encargar de testear el mensaje a loguear para ver si cumple con las exigencias del logger
 * sean nivel de log, expresiones regulares
 */
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

	/*
	 * testea nivel del LOG, REG EXPR sobre el mensaje, y el FilterCustom
	 */
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

	/*
	 * el hashTabla por parametro contiene por clave a los pattern aplicados al mensaje y por valor, la clase que aplico el metodo
	 * dentro hay otro hashtable que por clave tiene los pattens aplicados (%l %m %n) y por valor las expresiones regulares
	 * del FILTER CUSTOM, se aparean ambos HASHTABLES y se machea cada transformacion  obtenido por cada clase Pattern con la expresio
	 * regular del FILTER CUSTOM
	 */

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
	
	/*
	 * si ocurre algun error, el mismo es almacenaro en el atributo errorMessage
	 */

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

}
