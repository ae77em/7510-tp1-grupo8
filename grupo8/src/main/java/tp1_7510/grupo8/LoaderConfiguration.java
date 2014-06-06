package tp1_7510.grupo8;

import java.util.Hashtable;

/*
 * interface que implementan las distintas clases encargas de tomar la configuracion desde disco
 */
public interface LoaderConfiguration {
	public int getLenghtLoggers();
	public String getNameLogger(int i);
	public String getTypeLogger(int i);
	public String getFileNameLogger(int i);
	public String getLevelLogLogger(int i);
	public String getFormatDateLogger(int i);
	public String getPatternMessageLogger(int i);
	public String getSeparatorLogger(int i);
	public String getRegularExpresionLogger(int i);
	public Hashtable<String,String> getCustomFilterLogger(int i);
}
