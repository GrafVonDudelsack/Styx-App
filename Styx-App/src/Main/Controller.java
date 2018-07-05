package Main;

public class Controller {
	
	/**NACH ALLEN NEU HINZUGEFÜGTEN DATEN MUSS DER LOADER RE-INITILISED WERDEN
	 * 
	 * Sonstige Reihenfolge:
	 * 1. User
	 * 2. Group
	 * 3. Message
	 */
	
	public static boolean log_in(String email, String password) {
		//NUR ZU TEST ZWECKEN -> Noch nicht fertig
		//WICHTIG Falls Positiv: UserID vom Server getten und in der Main bei lastUserID eintragen
		
		byte[] crypted_password = Security.ByteArrayVerschlüsseln(password.getBytes(), email);
		
		//Send
		
		return Main.logged_in = true;
	}
	
}
