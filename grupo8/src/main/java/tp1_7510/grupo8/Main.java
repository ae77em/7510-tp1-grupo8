package tp1_7510.grupo8;

public class Main{

	public static void main(String[] args) {
		Configurator configurator = new Configurator("src/main/java/tp1_7510/grupo8/Properties/logger.properties");
		
		Logger logger = new Logger( configurator.getPrintersConfiguration() );
        		
        logger.logFatal("MensajeERROR");
        
        logger.close();
	}
}
