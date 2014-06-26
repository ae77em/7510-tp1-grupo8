package tp1_7510.grupo8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tp1_7510.grupo8.Logger.Logger;


public class Application {

	public static void main(String[] args) {
		Configurator configurator = new Configurator();
		
		JSONArray jsonArrayConfigLogger = configurator.getConfigurationLogger();
		
		//solo para probar como se cargan las configuraciones
		/*System.out.println((JSONObject)jsonArrayConfigLogger.get(0));
		System.out.println((JSONObject)jsonArrayConfigLogger.get(1));
		System.out.println((JSONObject)jsonArrayConfigLogger.get(2));
		System.out.println((JSONObject)jsonArrayConfigLogger.get(3));*/
		
		Logger aLogger = new Logger((JSONObject)jsonArrayConfigLogger.get(2));
		
		aLogger.fatal("estoy logueando FATAL");
		aLogger.error("estoy logueando ERROR");
		aLogger.error("estoy logueando ERROR",new Exception());
		aLogger.debug("estoy logueando DEBUG");
		aLogger.trace("estoy logueando TRACE");
		aLogger.warn("estoy logueando WARN");		
		aLogger.fatal("estoy logueando FATAL");
		aLogger.debug("estoy logueando DEBUG");
		
		aLogger.close();
	}

}
