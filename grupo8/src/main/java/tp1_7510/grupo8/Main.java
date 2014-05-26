package tp1_7510.grupo8;

public class Main{

	public static void main(String[] args) {
		Configurator configurator = new Configurator();
		
		configurator.createPrinter("files","file4.txt");
		configurator.createPrinter("files","file2.txt");
		
		configurator.setFormatDate("file4.txt","%d{yyyyy-mm-dd hh:mm:ss}");
		configurator.setFormatMessage("file4.txt","%L-%n-%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M");
		configurator.setLogLevel("file4.txt",LogLevel.ERROR);
		configurator.setSeparator("file4.txt","*");
		
		configurator.setFormatDate("file2.txt","%d{hh:mm:ss}");
		configurator.setFormatMessage("file2.txt","%d{hh:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-MENSAJEFEO");
		configurator.setLogLevel("file2.txt",LogLevel.FATAL);
		
		configurator.createPrinter("consoles","SUPER_CONSOLA");
		configurator.setLogLevel("SUPER_CONSOLA",LogLevel.FATAL);
		configurator.setFormatMessage("consoleDefault","	-%n-%p-%n-%t-%n-%F-%M-%t");
		//configurer.setFormatMessage("SUPER_CONSOLA","%d{HH:mm:ss}-%n-%m-%n-%p-%n-%t-%n-%F-%M-%t-%%-hola");
		
		configurator.eraseDefaultConsole();
		
		Logger logger = new Logger( configurator.getPrintersConfiguration() );
        		
        logger.logError("Mensaje1");
        logger.logWarn("Mensaje1");
     
        //logger.close();
	}
}
