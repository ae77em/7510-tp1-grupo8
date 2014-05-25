package tp1_7510.grupo8;

public class Level {
	
	LogLevel logLevel;
	
	Level(LogLevel ll){
		logLevel = ll;
	}
	
	public Boolean isLowerOrEqual(LogLevel ll){
		return ll.ordinal() >= logLevel.ordinal();				
	}
	
	public void setLogLevel(LogLevel ll){
		logLevel = ll;
	}
	
	public LogLevel getLogLevel(){
		return logLevel;
	}
}
