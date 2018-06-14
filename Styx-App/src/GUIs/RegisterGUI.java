package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.SwingConstants;

public class RegisterGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Color orange = Manager.orange;
	
	
	
	public RegisterGUI() {
		
		this.setSize(1280,720);
		this.setResizable(false);
		
		JPanel panel_west = new JPanel();
		JPanel panel_east = new JPanel();
		
		
		
		panel_west.setBackground(orange);
		panel_west.setSize(new Dimension((int) ((double) this.getWidth() * 0.27), this.getHeight()));
		
		ImageIcon icon_logo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo_test.png")));
		JLabel label_icon_logo = new JLabel();
		label_icon_logo.setBounds(panel_west.getWidth()/2 - icon_logo.getIconWidth()/2, panel_west.getHeight()/2 - icon_logo.getIconHeight()/2, icon_logo.getIconWidth(), icon_logo.getIconHeight());
		label_icon_logo.setIcon(icon_logo);
		getContentPane().add(label_icon_logo);
		
		getContentPane().add(panel_west);
		
		
		panel_east.setBackground(Manager.ct.getBackground());
		panel_east.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		
		
		
		
		int entry_x = panel_west.getWidth() + 100;
		
		
		JLabel fn_text = new JLabel("Vorname");
		fn_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fn_text.setForeground(Manager.ct.getForeground());
		fn_text.setBounds(entry_x, 115, 200, 50);
		getContentPane().add(fn_text);
		
		JTextField fn_field = new JTextField();
		fn_field.setBorder(null);
		fn_field.setToolTipText("Enter Firstname");
		fn_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fn_field.setForeground(Manager.ct.getForeground());
		fn_field.setBackground(Manager.ct.getBackground());
		fn_field.setBounds(entry_x, fn_text.getY() + fn_text.getHeight(), 335, 50);
		getContentPane().add(fn_field);
		
		JSeparator fn_separator = new JSeparator();
		fn_separator.setForeground(Manager.ct.getForeground());
		fn_separator.setBackground(Manager.ct.getForeground());
		fn_separator.setBounds(entry_x, fn_field.getY() + fn_field.getHeight(), 335, 50);
		getContentPane().add(fn_separator);
		
		
		JLabel ln_text = new JLabel("Nachname");
		ln_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ln_text.setForeground(Manager.ct.getForeground());
		ln_text.setBounds(entry_x + fn_field.getWidth() + 50, 115, 200, 50);
		getContentPane().add(ln_text);
		
		JTextField ln_field = new JTextField();
		ln_field.setBorder(null);
		ln_field.setToolTipText("Enter Lastname");
		ln_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ln_field.setForeground(Manager.ct.getForeground());
		ln_field.setBackground(Manager.ct.getBackground());
		ln_field.setBounds(entry_x + fn_field.getWidth() + 50, ln_text.getY() + ln_text.getHeight(), 335, 50);
		getContentPane().add(ln_field);
		
		JSeparator ln_separator = new JSeparator();
		ln_separator.setForeground(Manager.ct.getForeground());
		ln_separator.setBackground(Manager.ct.getForeground());
		ln_separator.setBounds(entry_x + fn_field.getWidth() + 50, ln_field.getY() + ln_field.getHeight(), 335, 50);
		getContentPane().add(ln_separator);
		
		
		
		JLabel email_text = new JLabel("E-Mail");
		email_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		email_text.setForeground(Manager.ct.getForeground());
		email_text.setBounds(entry_x, ln_separator.getY() + 72, 225, 50);
		getContentPane().add(email_text);
		
		JTextField email_field = new JTextField();
		email_field.setBorder(null);
		email_field.setToolTipText("Enter Email-Address");
		email_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email_field.setForeground(Manager.ct.getForeground());
		email_field.setBackground(Manager.ct.getBackground());
		email_field.setBounds(entry_x, email_text.getY() + email_text.getHeight(), 720, 50);
		getContentPane().add(email_field);
		
		JSeparator email_separator = new JSeparator();
		email_separator.setForeground(Manager.ct.getForeground());
		email_separator.setBackground(Manager.ct.getForeground());
		email_separator.setBounds(entry_x, email_field.getY() + email_field.getHeight(), 720, 50);
		getContentPane().add(email_separator);
		
		
		JLabel password_text = new JLabel("<html>Zu Zwecken der Verifikation ihres Accounts senden wir ihnen ein vorläufiges, zufällig generiertes, Passwort an ihre Email-Adresse!</html>");
		password_text.setFont(new Font("Tahoma", Font.ITALIC, 20));
		password_text.setForeground(Manager.ct.getForeground());
		password_text.setBounds(entry_x, email_separator.getY() + 65, 720, 50);
		getContentPane().add(password_text);

		
		
		
		
		JButton register_button = new JButton("Registrieren");
		register_button.setBorderPainted(true);
		register_button.setFocusPainted(false);
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 32));
		register_button.setForeground(Manager.ct.getBackground());
		register_button.setBackground(orange);
		register_button.setBounds(entry_x, password_text.getY() + 80, 220, 60);
		getContentPane().add(register_button);
		
		JButton login_button = new JButton("Bereits registriert?");
		login_button.setHorizontalAlignment(SwingConstants.TRAILING);
		login_button.setBorderPainted(false);
		login_button.setFocusPainted(false);
		login_button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		login_button.setForeground(orange);
		login_button.setBackground(Manager.ct.getBackground());
		login_button.setBounds(password_text.getX() + password_text.getWidth() - 185, register_button.getY(), 200, 60);
		login_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.changeJFrame("login");
			}
		});
		getContentPane().add(login_button);
		
		
		
		
		JToggleButton jb_bc = new JToggleButton();
		ImageIcon bct_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bright_color_theme_logo.png")));
		ImageIcon dct_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dark_color_theme_logo.png")));
		jb_bc.setBounds(this.getWidth() - bct_icon.getIconWidth() - 35, 35, bct_icon.getIconWidth(), bct_icon.getIconHeight());
		jb_bc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Manager.switchColorTheme();
				
				if(Manager.ct == ColorTheme.BRIGHT) {
					jb_bc.setIcon(dct_icon);
				}else {
					jb_bc.setIcon(bct_icon);
				}

				panel_east.setBackground(Manager.ct.getBackground());
				
				fn_text.setForeground(Manager.ct.getForeground());
				fn_field.setForeground(Manager.ct.getForeground());
				fn_field.setBackground(Manager.ct.getBackground());
				fn_separator.setForeground(Manager.ct.getForeground());
				fn_separator.setBackground(Manager.ct.getForeground());
				
				ln_text.setForeground(Manager.ct.getForeground());
				ln_field.setForeground(Manager.ct.getForeground());
				ln_field.setBackground(Manager.ct.getBackground());
				ln_separator.setForeground(Manager.ct.getForeground());
				ln_separator.setBackground(Manager.ct.getForeground());
				
				email_text.setForeground(Manager.ct.getForeground());
				email_field.setForeground(Manager.ct.getForeground());
				email_field.setBackground(Manager.ct.getBackground());
				email_separator.setForeground(Manager.ct.getForeground());
				email_separator.setBackground(Manager.ct.getForeground());
				
				password_text.setForeground(Manager.ct.getForeground());

				register_button.setForeground(Manager.ct.getBackground());
				login_button.setBackground(Manager.ct.getBackground());
				
				
				getContentPane().repaint();
			}
		});
		if(Manager.ct == ColorTheme.DARK) {
			jb_bc.setIcon(bct_icon);
		}else {
			jb_bc.setIcon(dct_icon);
		}
		jb_bc.setBorderPainted(false);
		jb_bc.setFocusPainted(false);
		getContentPane().add(jb_bc);
		
		
		getContentPane().add(panel_east);
		
		
		
	}
}
