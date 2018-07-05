package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import GUIs.ColorTheme;
import GUIs.Manager;
import SQLITE.Loader;
import SQLITE.SQLITE;

public class Main {
	
	public static SQLITE sqlite;
	public static boolean logged_in;
	public static Integer activeUserID;
	
	public static String lastUserID;
	public static ColorTheme ct;
	
	public static void main(String[] args) {
		Config.createFile();
		
		lastUserID = Config.getProp("lastUserID") + "";
		String ct_value = Config.getProp("ColorTheme") + "";
		if(ct_value.equalsIgnoreCase("bright")) {
			ct = ColorTheme.BRIGHT;
		}else {
			ct = ColorTheme.DARK;
		}
		
		logged_in = false;
		activeUserID = 0;
		
		sqlite = new SQLITE();
		sqlite.connect();

		Loader.init();
		
		Manager.openJFrame();
	}
	
	public static void exit() {
		Config.saveProp("lastUserID", activeUserID + "");
		String ct_value = "dark";
		if(ct == ColorTheme.BRIGHT) {
			ct_value = "bright";
		}
		Config.saveProp("ColorTheme", ct_value);
		
		System.exit(0);
	}
	
	
	
	static class Config {
		
		public static Properties prop = new Properties();
		private static String filename = "user_config";
		
		public static void saveProp(String title, String value) {
			try {
				prop.setProperty(title, value);
				prop.store(new FileOutputStream(filename), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getProp(String title) {
			String value = "";
			try {
				prop.load(new FileInputStream(filename));
				value =  prop.getProperty("title");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return value;
		}
		
		public static void createFile() {
			String path = "./" + filename;
			File f = new File(path);
			
			if(!f.exists()) {
				f.getParentFile().mkdirs(); 
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
