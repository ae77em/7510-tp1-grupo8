package tp1_7510.grupo8.Patterns;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PatternDate implements Pattern {
	
	SimpleDateFormat m_sdf;

	public PatternDate(String p) {
		m_sdf = new SimpleDateFormat(p);	
	}	
	
	@Override //concatena la fecha
	public String formatText(String s) {
		String fecha = m_sdf.format(new Date());
		return s + fecha; 
	}

}
