package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import Main.Controller;

public class LoginGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Color blue = Manager.blue;
	
	
	
	public LoginGUI() {
		
		this.setSize(1280,720);
		this.setResizable(false);
		
		JPanel panel_west = new JPanel();
		JPanel panel_east = new JPanel();
		

		panel_west.setBackground(blue);
		panel_west.setSize(new Dimension((int) ((double) this.getWidth() * 0.27), this.getHeight()));
		
		ImageIcon icon_logo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carl_logo.png")));
		JLabel label_icon_logo = new JLabel();
		label_icon_logo.setBounds(panel_west.getWidth()/2 - icon_logo.getIconWidth()/2, panel_west.getHeight()/2 - icon_logo.getIconHeight()/2, icon_logo.getIconWidth(), icon_logo.getIconHeight());
		label_icon_logo.setIcon(icon_logo);
		getContentPane().add(label_icon_logo);
		
		getContentPane().add(panel_west);
		
		
		panel_east.setBackground(Manager.ct.getBackground());
		panel_east.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		
		
		
		
		int entry_x = panel_west.getWidth() + 100;
		
		
		JLabel email_text = new JLabel("E-Mail");
		email_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		email_text.setForeground(Manager.ct.getForeground());
		email_text.setBounds(entry_x, 130, 200, 50);
		getContentPane().add(email_text);
		
		JTextField email_field = new JTextField();
		email_field.setBorder(null);
		email_field.setToolTipText("Enter Email-Adress");
		email_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email_field.setForeground(Manager.ct.getForeground());
		email_field.setBackground(Manager.ct.getBackground());
		email_field.setBounds(entry_x, email_text.getY() + email_text.getHeight(), 700, 50);
		getContentPane().add(email_field);
		
		JSeparator email_separator = new JSeparator();
		email_separator.setForeground(Manager.ct.getForeground());
		email_separator.setBackground(Manager.ct.getForeground());
		email_separator.setBounds(entry_x, email_field.getY() + email_field.getHeight(), 700, 50);
		getContentPane().add(email_separator);
		
		
		
		JLabel password_text = new JLabel("Passwort");
		password_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		password_text.setForeground(Manager.ct.getForeground());
		password_text.setBounds(entry_x, email_separator.getY() + 110, 200, 50);
		getContentPane().add(password_text);
		
		JPasswordField password_field = new JPasswordField();
		password_field.setBorder(null);
		password_field.setToolTipText("Enter Password");
		password_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password_field.setForeground(Manager.ct.getForeground());
		password_field.setBackground(Manager.ct.getBackground());
		password_field.setBounds(entry_x, password_text.getY() + password_text.getHeight(), 700, 50);
		getContentPane().add(password_field);
		
		JSeparator password_separator = new JSeparator();
		password_separator.setForeground(Manager.ct.getForeground());
		password_separator.setBackground(Manager.ct.getForeground());
		password_separator.setBounds(entry_x, password_field.getY() + password_field.getHeight(), 700, 50);
		getContentPane().add(password_separator);
		
		
		JButton login_button = new JButton("Anmelden");
		login_button.setBorderPainted(true);
		login_button.setFocusPainted(false);
		login_button.setFont(new Font("Tahoma", Font.PLAIN, 32));
		login_button.setForeground(Manager.ct.getBackground());
		login_button.setBackground(blue);
		login_button.setBounds(entry_x, password_separator.getY() + 80, 220, 60);
		login_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton) e.getSource() == login_button) {
					
					String email = email_field.getText().trim();
					char[] password_chars = password_field.getPassword();
					String password = "";
					
					for(char c : password_chars) {
						password += c;
					}
					
					if(Controller.log_in(email, password)) {
						Manager.changeJFrame("main");
					}else {
						email_separator.setForeground(Color.RED);
						email_separator.setBackground(Color.RED);
						password_separator.setForeground(Color.RED);
						password_separator.setBackground(Color.RED);
					}
				}
			}
		});
		getContentPane().add(login_button);
		
		JButton register_button = new JButton("Noch nicht registriert?");
		register_button.setHorizontalAlignment(SwingConstants.TRAILING);
		register_button.setBorderPainted(false);
		register_button.setFocusPainted(false);
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		register_button.setForeground(blue);
		register_button.setBackground(Manager.ct.getBackground());
		register_button.setBounds(entry_x + password_separator.getWidth() - 185, password_separator.getY() + 85, 200, 60);
		register_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton) e.getSource() == register_button)
					Manager.changeJFrame("register");
			}
		});
		getContentPane().add(register_button);
		
		
		
		
		/*JToggleButton jb_bc = new JToggleButton();
		ImageIcon bct_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bright_color_theme_logo.png")));
		ImageIcon dct_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dark_color_theme_logo.png")));
		jb_bc.setBounds(this.getWidth() - bct_icon.getIconWidth() - 35, 35, bct_icon.getIconWidth(), bct_icon.getIconHeight());
		jb_bc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if((JToggleButton) e.getSource() == jb_bc) {
					Manager.switchColorTheme();
					
					if(Manager.ct == ColorTheme.BRIGHT) {
						jb_bc.setIcon(dct_icon);
					}else {
						jb_bc.setIcon(bct_icon);
					}
	
					panel_east.setBackground(Manager.ct.getBackground());
					
					email_text.setForeground(Manager.ct.getForeground());
					email_field.setForeground(Manager.ct.getForeground());
					email_field.setBackground(Manager.ct.getBackground());
					email_separator.setForeground(Manager.ct.getForeground());
					email_separator.setBackground(Manager.ct.getForeground());
					
					password_text.setForeground(Manager.ct.getForeground());
					password_field.setForeground(Manager.ct.getForeground());
					password_field.setBackground(Manager.ct.getBackground());
					password_separator.setForeground(Manager.ct.getForeground());
					password_separator.setBackground(Manager.ct.getForeground());
	
					login_button.setForeground(Manager.ct.getBackground());
					register_button.setBackground(Manager.ct.getBackground());
					getContentPane().repaint();
				}
			}
		});
		if(Manager.ct == ColorTheme.DARK) {
			jb_bc.setIcon(bct_icon);
		}else {
			jb_bc.setIcon(dct_icon);
		}
		jb_bc.setBorderPainted(false);
		jb_bc.setFocusPainted(false);
		getContentPane().add(jb_bc);*/
		
		
		getContentPane().add(panel_east);
		
	}
	
}
