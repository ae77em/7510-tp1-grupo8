package tp1_7510.grupo8;

import java.util.Hashtable;

public class LoaderDefaultConfiguration implements LoaderConfiguration {
	
	public LoaderDefaultConfiguration(){
		
	}

	public int getLenghtLoggers() {

		return 1;
	}

	public String getNameLogger(int i) {

		return "CONSOLA";
	}

	public String getTypeLogger(int i) {

		return LogOutput.CONSOLES.toString(); 
	}

	public String getFileNameLogger(int i) {

		return "";
	}

	public String getLevelLogLogger(int i) {

		return LogLevel.TRACE.toString();
	}

	public String getFormatDateLogger(int i) {

		return "dd-M-yyyy hh:mm:ss";
	}

	public String getPatternMessageLogger(int i) {

		return "%L%n%d%n%p%n%m";
	}

	public String getSeparatorLogger(int i) {

		return "-";
	}

	public String getRegularExpresionLogger(int i) {
		return "";
	}

	public Hashtable<String, String> getCustomFilterLogger(int i) {
		//por default no lleva ningun filtro custom
		return new Hashtable<String, String>();
	}
}
