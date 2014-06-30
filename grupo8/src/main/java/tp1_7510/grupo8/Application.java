package tp1_7510.grupo8;

import org.slf4j.*;

public class Application {
	public static void main(String[] args){
		Logger logger1 = LoggerFactory.getLogger("logger1");
		Logger logger2 = LoggerFactory.getLogger("logger2");
		Logger logger3 = LoggerFactory.getLogger("logger3");

		logger1.info("Hello World..",new NullPointerException());	
		logger1.info("Hola Mundo..");	
		logger1.info("Hallo Welt..");
		
		logger2.info("no deberia loguearse");
		logger2.debug("12389");
		
		logger3.trace("no deberia loguearse...");
		logger3.warn("esto deberia loguearse con excepcion...", new NullPointerException());
		logger3.error("esto deberia loguearse tambien...");
	}
}
