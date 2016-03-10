package retrostruct.epsilon.debug;

public class Log {
	
	public static boolean DEBUG_MODE = false;
	
	public static void print(String s) {
		if(!DEBUG_MODE) 
			return;
		
		System.out.println(s);	
	}

}
