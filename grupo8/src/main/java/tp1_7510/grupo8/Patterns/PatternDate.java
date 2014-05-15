package tp1_7510.grupo8.Patterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatternDate implements Pattern {
	
	SimpleDateFormat m_sdf;
	
	public PatternDate() {
		m_sdf = new SimpleDateFormat("dd/MM/yyyy");	
	}	

	public PatternDate(String p) {
		m_sdf = new SimpleDateFormat(p);	
	}	
	
	@Override //concatena la fecha
	public String addText(String s) {
		String fecha = m_sdf.format(new Date());
		return s + fecha; 
	}

	@Override
	public String getText() {
		
		Date d1 = new Date();
		String fechaString = m_sdf.format(d1);
		
		return fechaString;
	}

}
