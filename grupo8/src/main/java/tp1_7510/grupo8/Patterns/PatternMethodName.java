package tp1_7510.grupo8.Patterns;

public class PatternMethodName implements Pattern {

	public PatternMethodName() {
		
	}
	 
	public String addText(String s) {
		/* imprime el nombre dle metodo invocante */
		return  s + new Object(){}.getClass().getEnclosingMethod().getName();
	}

	public String getText() {
		return new Object(){}.getClass().getEnclosingMethod().getName();
	}
	
	public String toString(){
		return "methodName";
	}
}
