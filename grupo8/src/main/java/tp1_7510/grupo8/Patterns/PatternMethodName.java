package tp1_7510.grupo8.Patterns;

public class PatternMethodName implements Pattern {

	public PatternMethodName() {
		
	}
	
	@Override //imprime el nombre dle metodo invocante
	public String formatText(String s) {
		//NI IDEA SI ANDA
		return  s + new Object(){}.getClass().getEnclosingMethod().getName();
	}

}
