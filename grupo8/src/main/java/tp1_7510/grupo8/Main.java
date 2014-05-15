package tp1_7510.grupo8;

public class Main {

	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		
		configurer.createFile("file4.txt");
		
		configurer.setFormatDate("file4.txt","%d{yyyyy-mm-dd hh:mm:ss}");
		configurer.setFormatMessage("file4.txt","%L-%n-%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M");
		configurer.setLogLevel("file4.txt","ERROR");
		configurer.setSeparator("file4.txt","*");
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );
        
        loguer.log("Un mensaje DEBUG");
        loguer.log("Un mensaje DEBUG");
	}
}
//%m %d %L %p %t %n %F
