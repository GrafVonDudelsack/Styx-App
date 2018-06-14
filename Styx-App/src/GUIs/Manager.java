package GUIs;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Manager {
	
	public static ColorTheme ct = ColorTheme.BRIGHT;
	public static Color orange = new Color(232,73,29);
	
	
	public static JFrame frame = new JFrame("Styx");
	
	//JFrames
	static Container login = new LoginGUI().getContentPane();
	static Container register = new RegisterGUI().getContentPane();
	
	public static void openJFrame() {
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		frame.setContentPane(login);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void changeJFrame(String frame_typ) {
		if(frame_typ.equalsIgnoreCase("login")) {
			frame.setContentPane(login);
		}
		if(frame_typ.equalsIgnoreCase("register")) {
			frame.setContentPane(register);
		}
		
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	public static void switchColorTheme() {
		if(ct == ColorTheme.BRIGHT) {
			ct = ColorTheme.DARK;
		}else {
			ct = ColorTheme.BRIGHT;
		}
		
		reloadContentPanes();
	}

	public static void reloadContentPanes() {
		login = new LoginGUI().getContentPane();
		register = new RegisterGUI().getContentPane();
	}
}
