package Main;

import GUIs.Manager;
import SQLITE.Loader;
import SQLITE.SQLITE;

public class Main {
	
	public static SQLITE sqlite;
	public static boolean logged_in;
	
	public static void main(String[] args) {
		logged_in = false;
		
		sqlite = new SQLITE();
		sqlite.connect();

		Loader.init();
		
		Manager.openJFrame();
	}
	
	public static void exit() {
		System.exit(0);
	}
	
}
