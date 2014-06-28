package tp1_7510.grupo8.Printer;

public class CustomDestiny {

	private static String DESTINY;
	private static CustomDestiny INSTANCE;
	
	private CustomDestiny(String destinyValue) {
		DESTINY = destinyValue;
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
        if (INSTANCE == null) createInstance(destinyValue);
        return INSTANCE;
    }
	
}


