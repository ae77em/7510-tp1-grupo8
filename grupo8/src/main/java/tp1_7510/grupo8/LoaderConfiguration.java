package tp1_7510.grupo8;

import java.util.Hashtable;

public interface LoaderConfiguration {
	public int getLenghtLoggers();
	public String getNameLogger();
	public String getTypeLogger();
	public String getFileNameLogger();
	public String getLevelLogLogger();
	public String getFormatDateLogger();
	public String getPatternMessageLogger();
	public String getSeparatorLogger();
	public String getRegularExpresionLogger();
	public Hashtable<String,String> getCustomFilterLogger();
}
