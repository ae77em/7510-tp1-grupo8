package tp1_7510.grupo8;

import java.util.Hashtable;

import tp1_7510.grupo8.Logger.LogLevel;

/*
 * simplemente devuelve la configuracion por default del logger, en caso de que no se haya especificado ningun archivo
 * de configuraciones
 */
public class LoaderDefaultConfiguration implements LoaderConfiguration {
	
	public LoaderDefaultConfiguration(){
		
	}

	public int getLenghtLoggers() {

		return 1;
	}

	public String getNameLogger(int i) {

		return "CONSOLE";
	}

	public String getTypeLogger(int i) {

		return LogOutput.CONSOLES.toString(); 
	}

	public String getFileNameLogger(int i) {

		return "CONSOLE";
	}

	public String getLevelLogLogger(int i) {

		return LogLevel.TRACE.toString();
	}

	public String getFormatDateLogger(int i) {

		return "dd-M-yyyy hh:mm:ss";
	}

	public String getPatternMessageLogger(int i) {

		return "%L-%n-%d-%n-%p-%n-%m";
	}

	public String getSeparatorLogger(int i) {

		return "-";
	}

	public String getRegularExpresionLogger(int i) {
		//por default no lleva ningun filtro 
		return "";
	}

	public Hashtable<String, String> getCustomFilterLogger(int i) {
		//por default no lleva ningun filtro custom
		return new Hashtable<String, String>();
	}
}
