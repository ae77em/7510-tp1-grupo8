package tp1_7510.grupo8;

public class Main{

	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		
		configurer.createPrinter("files","file4.txt");
		configurer.createPrinter("files","file2.txt");
		
		configurer.setLogLevel("file4.txt","ERROR");
		configurer.setLogLevel("file2.txt","FATAL");
		
		configurer.eraseDefaultConsole();
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );
        		
        loguer.log("SOY UN MENSAJE NUEVO",LogLevel.ERROR);
     
        loguer.close();
	}
}
