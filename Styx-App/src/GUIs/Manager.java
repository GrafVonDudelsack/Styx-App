package GUIs;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import Main.Main;

public class Manager {
	
	/**
	 * Einige farben von https://discordapp.com/branding
	 */
	public static ColorTheme ct = Main.ct;
	public static Color blue = new Color(114, 137, 218);//public static Color orange = new Color(232,73,29);
	public static Color transparent = new Color(0,0,0,0);
	public static Color white = new Color(225, 225, 225);
	public static Color light_gray = new Color(153, 170, 181);
	public static Color dark_shade = new Color(35,39,42, 120);
	public static Color bright_shade = new Color(225,225,225,20);
	public static Color light_dark = new Color(127, 129, 132);
	public static Color dark = new Color(35, 39, 42);
	public static Color darkest = new Color(25, 29, 32);
	

	static int posX = 0;
	static int posY = 0;
	
	static ImageIcon icon = new ImageIcon(Manager.class.getResource("/GUIs/Logo.png"));
	static JMenuBar menu = new JMenuBar() {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			icon.paintIcon(this, g, 3, 3);
		}
		
	};
	static JMenuItem exit = new JMenuItem("");
	static JMenuItem minimize = new JMenuItem("");
	static JMenuItem logout = new JMenuItem("");
	static JMenuItem settings = new JMenuItem("");
	
	/**
	 * JFrames
	 */
	static JFrame frame = new JFrame("Styx");
	static Container login = new LoginGUI().getContentPane();
	static Container register = new RegisterGUI().getContentPane();
	static Container main = new MainGUI().getContentPane();
	
	private static void initialiseJMenuBar() {
		menu.setBackground(transparent);
		
		exit.setBackground(menu.getBackground());
		exit.setForeground(null);
		exit.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/Exit.png")));
		exit.setBorderPainted(false);
		exit.setFocusPainted(true);
		exit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
				exit.setBackground(menu.getBackground());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBackground(new Color(225, 100, 100));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JMenuItem) e.getSource() == exit)
					Main.exit();
			}
		});
		exit.setMaximumSize(new Dimension(55, 55));
		exit.setMinimumSize(new Dimension(55, 55));
		menu.add(exit);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		minimize.setBackground(menu.getBackground());
		minimize.setForeground(null);
		minimize.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/minimize.png")));
		minimize.setBorderPainted(false);
		minimize.setFocusPainted(true);
		minimize.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
				minimize.setBackground(menu.getBackground());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				minimize.setBackground(light_dark);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});
		minimize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JMenuItem) e.getSource() == minimize)
					frame.setState(JFrame.ICONIFIED);
			}
		});
		minimize.setMaximumSize(new Dimension(55, 55));
		minimize.setMinimumSize(new Dimension(55, 55));
		menu.add(minimize);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		logout.setBackground(menu.getBackground());
		logout.setForeground(null);
		logout.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/LogOut.png")));
		logout.setBorderPainted(false);
		logout.setFocusPainted(true);
		logout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
				logout.setBackground(menu.getBackground());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				logout.setBackground(light_dark);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JMenuItem) e.getSource() == logout)
					logout.setBackground(white);
					reduceMenu();
					changeJFrame("login");
			}
		});
		logout.setMaximumSize(new Dimension(55, 55));
		logout.setMinimumSize(new Dimension(55, 55));
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		settings.setBackground(menu.getBackground());
		settings.setForeground(null);
		settings.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/Gear.png")));
		settings.setBorderPainted(false);
		settings.setFocusPainted(false);
		settings.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
				settings.setBackground(menu.getBackground());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				settings.setBackground(light_dark);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JMenuItem) e.getSource() == settings)
					System.out.println("SETTINGS");
			}
		});
		settings.setMaximumSize(new Dimension(55, 55));
		settings.setMinimumSize(new Dimension(55, 55));
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		menu.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		menu.setBackground(white);
		menu.setForeground(null);
		/**
		 * Drag JFrame
		 */
		menu.addMouseListener(new MouseAdapter()
		{
		   public void mousePressed(MouseEvent e)
		   {
		      posX=e.getX();
		      posY=e.getY();
		   }
		});
		
		menu.addMouseMotionListener(new MouseAdapter()
		{
		     public void mouseDragged(MouseEvent evt)
		     {		
		    	 frame.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
							
		     }
		});
	}
	
	public static void openJFrame() {
		initialiseJMenuBar();
		
		frame.setSize(1280, 720);
		frame.setResizable(false);
		frame.setUndecorated(true);
		
		frame.setJMenuBar(menu);
		
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
		if(frame_typ.equalsIgnoreCase("main")) {
			frame.setContentPane(main);
			completeMenu();
			//Data
		}
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		menu.revalidate();
		Graphics g = menu.getGraphics();
		menu.repaint();
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
		main = new MainGUI().getContentPane();
	}
	
	public static void completeMenu() {
		logout.setVisible(true);
		settings.setVisible(true);
		menu.add(logout);
		menu.add(settings);
		menu.repaint();
	}
	
	public static void reduceMenu() {
		logout.setVisible(false);
		settings.setVisible(false);
		menu.remove(logout);
		menu.remove(settings);
	}
}
