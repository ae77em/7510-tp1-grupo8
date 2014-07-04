package tp1_7510.grupo8.ConfigurationLoaders;

import java.util.Hashtable;

import tp1_7510.grupo8.CONSTANTS.LogLevel;
import tp1_7510.grupo8.CONSTANTS.LogOutput;

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

	public String getLogLevelLogger(int i) {

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
		return "";
	}

	public Hashtable<String, String> getCustomFilterLogger(int i) {
		return new Hashtable<String, String>();
	}

	public String getCustomClassNameLogger(int i) {
		return "";
	}
}
