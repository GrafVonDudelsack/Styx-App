package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

import Main.Controller;

public class CreateGroupGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JPanel create;
	
	ArrayList<String> emails;
	
	public CreateGroupGUI() {
		emails = new ArrayList<>();
		
		this.setSize(1280,720);
		this.setResizable(false);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		JScrollPane scroll;
		
		create = new JPanel();
		
		create.setBackground(Manager.ct.getBackground());
		create.setForeground(Manager.ct.getForeground());
		create.setSize(1280, 720);
		
		JButton back = new JButton();
		back.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/back.png")));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.changeJFrame("main");
			}
		});
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setBackground(create.getBackground());
		back.setForeground(create.getForeground());
		back.setBounds(10, 10, 50, 50);
		getContentPane().add(back);
		
		JLabel create_label = new JLabel("Gruppe erstellen:");
		create_label.setFont(new Font("Tahoma", Font.BOLD, 28));
		create_label.setBackground(create.getBackground());
		create_label.setForeground(create.getForeground());
		create_label.setBounds(85, 10, 500, 50);
		getContentPane().add(create_label);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel group_text = new JLabel("Neuen Chat / Neue Gruppe:");
		group_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		group_text.setForeground(Manager.ct.getForeground());
		group_text.setBounds(create_label.getX(), create_label.getY() + create_label.getHeight() + 20, 350, 50);
		getContentPane().add(group_text);
		
		JTextField group_field = new JTextField();
		group_field.setBorder(null);
		group_field.setToolTipText("Enter Group's Name");
		group_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		group_field.setForeground(Manager.ct.getForeground());
		group_field.setBackground(Manager.ct.getBackground());
		group_field.setBounds(create_label.getX(), group_text.getY() + group_text.getHeight(), 400, 50);
		getContentPane().add(group_field);
		
		JSeparator group_separator = new JSeparator();
		group_separator.setForeground(Manager.ct.getForeground());
		group_separator.setBackground(Manager.ct.getForeground());
		group_separator.setBounds(create_label.getX(), group_field.getY() + group_field.getHeight(), 400, 50);
		getContentPane().add(group_separator);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		JLabel email_text = new JLabel("E-Mail Addresse:");
		email_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		email_text.setForeground(Manager.ct.getForeground());
		email_text.setBounds(group_field.getX() + group_field.getWidth() + 50, create_label.getY() + create_label.getHeight() + 20, 350, 50);
		getContentPane().add(email_text);
		
		JTextField email_field = new JTextField();
		email_field.setBorder(null);
		email_field.setToolTipText("Enter a User's EMail");
		email_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email_field.setForeground(Manager.ct.getForeground());
		email_field.setBackground(Manager.ct.getBackground());
		email_field.setBounds(email_text.getX(), email_text.getY() + email_text.getHeight(), 400, 50);
		getContentPane().add(email_field);
		
		JSeparator email_separator = new JSeparator();
		email_separator.setForeground(Manager.ct.getForeground());
		email_separator.setBackground(Manager.ct.getForeground());
		email_separator.setBounds(email_text.getX(), email_field.getY() + email_field.getHeight(), 400, 50);
		getContentPane().add(email_separator);
		
		JButton email_button = new JButton("Hinzufügen");
		email_button.setBorderPainted(true);
		email_button.setFocusPainted(false);
		email_button.setFont(new Font("Tahoma", Font.PLAIN, 32));
		email_button.setForeground(Manager.ct.getBackground());
		email_button.setBackground(Manager.blue);
		email_button.setBounds(email_field.getX() + email_field.getWidth() + 35, email_field.getY(), 200, 50);
		email_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				String email = email_field.getText().trim();
				
				//Valid email check
				if(!email.contains("@") || !email.contains(".")) {
					email_separator.setBackground(Color.RED);
					return;
				}else {
					email_separator.setBackground(Manager.ct.getForeground());
				}
				
				email_field.setText("");
				emails.add(email);
				model.addElement(email + "       ");
				list.setModel(model);
			}
		});
		getContentPane().add(email_button);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		list.setBackground(create.getBackground());
		list.setForeground(create.getForeground());
		list.setBorder(new MatteBorder(0, 0, 0, 0, create.getForeground()));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setFont(new Font("Tahoma", 0, 18));
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setPreferredSize(new Dimension(400*2 + 50 + 35, 720 - (group_separator.getY() + 40)));
		list.setBounds(create_label.getX(), group_separator.getY() + group_separator.getHeight() + 50, this.getWidth() - (email_separator.getX() + email_separator.getWidth()) - create_label.getX(), this.getHeight() - list.getY() - 40);
		scroll = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(new MatteBorder(1, 0, 0, 0, create.getForeground()));
		scroll.setBackground(list.getBackground());
		scroll.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		scroll.setPreferredSize(new Dimension(400*2 + 50 + 35, 720 - (group_separator.getY() + 40)));
		scroll.setBounds(create_label.getX(), group_separator.getY() + group_separator.getHeight() + 50, 400*2 + 50 + 35, this.getHeight() - scroll.getY() - 40);
		getContentPane().add(scroll);
		
		JLabel list_text = new JLabel("Benutzer:");
		list_text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		list_text.setForeground(Manager.ct.getForeground());
		list_text.setBounds(scroll.getX(), scroll.getY() - 50, 350, 50);
		getContentPane().add(list_text);
		
		JButton send = new JButton();
		send.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/send.png")));
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = group_field.getText().trim();
				if(name.isEmpty()) {
					group_separator.setBackground(Color.RED);
					return;
				}else {
					group_separator.setBackground(Manager.ct.getForeground());
				}
				
				if(emails.isEmpty()) {
					email_separator.setBackground(Color.RED);
					return;
				}else {
					group_separator.setBackground(Manager.ct.getForeground());
				}
				
				Controller.createGroup(name, emails);
				
				Manager.reloadContentPanes("main");
			}
		});
		send.setBorderPainted(false);
		send.setFocusPainted(false);
		send.setBackground(create.getBackground());
		send.setForeground(create.getForeground());
		send.setBounds(scroll.getX() + scroll.getWidth() + 15, scroll.getY(), 50, 50);
		getContentPane().add(send);
		
		
		getContentPane().add(create);
	}

}
