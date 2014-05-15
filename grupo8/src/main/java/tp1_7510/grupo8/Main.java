package tp1_7510.grupo8;

public class Main {

	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		
		configurer.createFile("file4");
		
		configurer.setFormatDate("file4","%d{yyyyy-mm-dd hh:mm:ss}");
		configurer.setFormatMessage("file4","%d{HH:mm:ss}-%t-%p-%T-%m");
		configurer.setLogLevel("file4","ERROR");
		configurer.setSeparator("file4","*");
		
		Logger loguer = new Logger( configurer.getPrintersConfiguration() );
        
        //loguer.log("Un mensaje DEBUG",LogLevel.DEBUG);
	}
}
