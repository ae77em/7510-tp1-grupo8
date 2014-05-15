package tp1_7510.grupo8;

public class Main{

	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		
		configurer.createFile("file4.txt");
		configurer.createFile("file2.txt");
		
		configurer.setFormatDate("file4.txt","%d{yyyyy-mm-dd hh:mm:ss}");
		configurer.setFormatMessage("file4.txt","%L-%n-%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M");
		configurer.setLogLevel("file4.txt","ERROR");
		configurer.setSeparator("file4.txt","*");
		
		configurer.setFormatDate("file2.txt","%d{hh:mm:ss}");
		configurer.setFormatMessage("file2.txt","%d{hh:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-MENSAJEFEO");
		configurer.setLogLevel("file2.txt","DEBUG");
		configurer.setSeparator("file2.txt","-");
		
		configurer.createConsole("SUPER_CONSOLA");
		configurer.setFormatMessage("consoleDefault","%L-%n-%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M-%t");
		configurer.setFormatMessage("SUPER_CONSOLA","%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M-%t-%%-hola");
		
		configurer.eraseDefaultConsole();
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );
        		
        loguer.log("Mensaje1");
     
        loguer.close();
	}
}
