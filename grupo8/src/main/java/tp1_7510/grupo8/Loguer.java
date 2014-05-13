package tp1_7510.grupo8;

import java.util.ArrayList;

import tp1_7510.grupo8.Printer.Printer;

public class Loguer {
	
	private ArrayList<Printer> m_Printers;
	private FormaterMessage m_FormaterMessage;

	public void log(String message, LogLevel level) {
		String formatedMessage;
        
        if(isGreaterOrEqualThanLevelConfigured(level)){
        	formatedMessage = m_FormaterMessage.formatMessage( message, level );
                
            for (int i = 0; i < m_Printers.size(); i++){
            	m_Printers.get(i).print( formatedMessage );
            }
        }
	}

	private boolean isGreaterOrEqualThanLevelConfigured(LogLevel level) {
		return true;
	}
}
