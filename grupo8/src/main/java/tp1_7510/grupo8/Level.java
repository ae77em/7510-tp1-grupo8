package tp1_7510.grupo8;
/*
 * clase encargada de trabajar con los LEVEL de mensaje
 */
public class Level {
	
	LogLevel logLevel;
	
	public Level(LogLevel ll){
		logLevel = ll;
	}
	
	public Boolean isLowerOrEqual(LogLevel ll){
		return ll.ordinal() <= logLevel.ordinal();				
	}
	
	public void setLogLevel(LogLevel ll){
		logLevel = ll;
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
}
