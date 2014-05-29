package tp1_7510.grupo8.Patterns;

public class PatternFilename implements Pattern {

	String fileName;

	public PatternFilename(String p) {
		fileName = p;
	}
	
	@Override //imprime el nombre de la consola o archivo sobre el cual se esta logueando
	public String addText(String s) {
		return  s + fileName;
	}

	@Override
	public String getText() {
		return fileName;
	}

}
