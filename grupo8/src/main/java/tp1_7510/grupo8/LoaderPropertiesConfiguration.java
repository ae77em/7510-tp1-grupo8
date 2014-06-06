package tp1_7510.grupo8;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

public class LoaderPropertiesConfiguration implements LoaderConfiguration{
	
	private Object properties;

	public LoaderPropertiesConfiguration(String pathConfig){
		properties = new Properties();
        
        InputStream input = null;
         
        try {
               // input = new FileInputStream(pathProperties);     
                ((Properties) properties).load(input);
         
        } catch (IOException ex) {
                ex.printStackTrace();
        }
        
        try {
                input.close();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
	}


	public int getLenghtLoggers() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getNameLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getTypeLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFileNameLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getLevelLogLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFormatDateLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPatternMessageLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSeparatorLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getRegularExpresionLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public Hashtable<String, String> getCustomFilterLogger(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
