package Main;

public class Controller {
	
	/**NACH ALLEN NEU HINZUGEF�GTEN DATEN MUSS DER LOADER RE-INITILISED WERDEN
	 * 
	 * Sonstige Reihenfolge:
	 * 1. User
	 * 2. Group
	 * 3. Message
	 */
	
	public static boolean log_in(String email, String password) {
		//NUR ZU TEST ZWECKEN -> Noch nicht fertig
		
		byte[] crypted_password = Security.ByteArrayVerschl�sseln(password.getBytes(), email);
		
		//Send
		
		return Main.logged_in = true;
	}
	
}
