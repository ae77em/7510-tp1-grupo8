package tp1_7510.grupo8.Patterns;

public class PatternMethodName implements Pattern {

	public PatternMethodName() {
		
	}
	
	@Override 
	public String addText(String s) {
		/* imprime el nombre dle metodo invocante */
		return  s + new Object(){}.getClass().getEnclosingMethod().getName();
	}

	@Override
	public String getText() {
		return new Object(){}.getClass().getEnclosingMethod().getName();
	}

}
