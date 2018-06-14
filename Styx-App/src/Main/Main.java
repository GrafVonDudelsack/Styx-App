package Main;

import GUIs.Manager;
import SQLITE.SQLITE;

public class Main {
	
	public static SQLITE sqlite;
	
	public static void main(String[] args) {
		Manager.openJFrame();
		
		sqlite = new SQLITE();
		sqlite.connect();
	}
	
}
