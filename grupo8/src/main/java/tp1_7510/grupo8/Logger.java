package tp1_7510.grupo8;

import java.util.ArrayList;
import java.util.Hashtable;

import tp1_7510.grupo8.Patterns.MessagePattern;
import tp1_7510.grupo8.Printer.Printer;

public class Logger {
	
	private ArrayList<Printer> m_Printers = new ArrayList<Printer>();
	private FormaterMessage m_FormaterMessage = new FormaterMessage();
	private Configurer m_ConfigurerProperties = new Configurer() ;
	
	Logger(Hashtable<String, ArrayList<Hashtable<String, String>>> hashtable){
		m_ConfigurerProperties.loadProperties();
	}
	
	public void log(String message, LogLevel level) {
		String formatedMessage;
        
        if(isGreaterOrEqualThanLevelConfigured(level)){
        	/*formatedMessage = m_FormaterMessage.formatMessage( message, level );
                
            for (int i = 0; i < m_Printers.size(); i++){
            	m_Printers.get(i).print( formatedMessage );
            }*/
        }
	}

	private boolean isGreaterOrEqualThanLevelConfigured(LogLevel level) {
		return true;
	}
}
