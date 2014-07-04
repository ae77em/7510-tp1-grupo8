package tp1_7510.grupo8.Printer;

public class CustomDestiny {

	private static String DESTINY;
	private static CustomDestiny INSTANCE;
	
	private CustomDestiny(String destinyValue) {
		DESTINY = "";
		DESTINY += destinyValue;
	}
	
	public static String getDestiny(){
		return DESTINY;
	}
	
    private synchronized static void createInstance(String destinyValue) {
        if (INSTANCE == null) { 
            INSTANCE = new CustomDestiny(destinyValue);
        }
    }
 
    public static CustomDestiny getInstance(String destinyValue) {
        if (INSTANCE == null) 
        	createInstance(destinyValue);
        else 
        	addToDestiny(System.getProperty("line.separator")+destinyValue);
        return INSTANCE;
    }

	private static void addToDestiny(String destinyValue) {
		DESTINY += destinyValue;		
	}
}


