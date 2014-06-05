package tp1_7510.grupo8;

import java.util.Hashtable;

public class LoaderDefaultConfiguration implements LoaderConfiguration {
	
	public LoaderDefaultConfiguration(){
		
	}

	@Override
	public int getLenghtLoggers() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getNameLogger(int i) {
		// TODO Auto-generated method stub
		return "CONSOLA";
	}

	@Override
	public String getTypeLogger(int i) {
		// TODO Auto-generated method stub
		return LogOutput.CONSOLES.toString(); 
	}

	@Override
	public String getFileNameLogger(int i) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getLevelLogLogger(int i) {
		// TODO Auto-generated method stub
		return LogLevel.INFO.toString();
	}

	@Override
	public String getFormatDateLogger(int i) {
		// TODO Auto-generated method stub
		return "dd-M-yyyy hh:mm:ss";
	}

	@Override
	public String getPatternMessageLogger(int i) {
		// TODO Auto-generated method stub
		return "%L%n%d%n%p%n%m";
	}

	@Override
	public String getSeparatorLogger(int i) {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public String getRegularExpresionLogger(int i) {
		return "";
	}

	@Override
	public Hashtable<String, String> getCustomFilterLogger(int i) {
		//por default no lleva ningun filtro custom
		return new Hashtable<String, String>();
	}
}
