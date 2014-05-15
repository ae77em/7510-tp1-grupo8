package tp1_7510.grupo8;

import junit.framework.TestCase;

public class TestLogger extends TestCase {

	Configurer configurer = new Configurer();
	
	/*configurer.createPrinter("files","file4.txt");
	configurer.createPrinter("files","file2.txt");
	
	configurer.setFormatDate("file4.txt","%d{yyyyy-mm-dd hh:mm:ss}");
	configurer.setFormatMessage("file4.txt","%L-%n-%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M");
	configurer.setLogLevel("file4.txt","ERROR");
	configurer.setSeparator("file4.txt","*");
	
	configurer.setFormatDate("file2.txt","%d{hh:mm:ss}");
	configurer.setFormatMessage("file2.txt","%d{hh:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-MENSAJEFEO");
	configurer.setLogLevel("file2.txt","FATAL");
	
	configurer.createPrinter("consoles","SUPER_CONSOLA");
	configurer.setLogLevel("SUPER_CONSOLA","FATAL");
	configurer.setFormatMessage("consoleDefault","	-%n-%p-%n-%t-%n-%F-%M-%t");
	//configurer.setFormatMessage("SUPER_CONSOLA","%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M-%t-%%-hola");
	
	configurer.eraseDefaultConsole();*/
	
	Logger loguer = new Logger( configurer.getPrintersConfiguration() );
    		
    //loguer.log("Mensaje1",LogLevel.ERROR);
}
