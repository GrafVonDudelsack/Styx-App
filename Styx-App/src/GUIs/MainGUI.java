package GUIs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import SQLITE.Group;
import SQLITE.Loader;
import SQLITE.Message;

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Color blue = Manager.blue;
	Color transparent = Manager.transparent;
	Color dark_shade = Manager.dark_shade;
	
	ArrayList<Group> groups;
	ArrayList<Message> messages;
	
	JList<JButton> group_list;
	DefaultListModel<JButton> group_model;
	

	public MainGUI() {
		groups = Loader.groups;
		messages = Loader.messages;

		
		this.setSize(1280,720);
		this.setResizable(false);
		
		
		JPanel panel_west = new JPanel();
		JPanel panel_east = new JPanel();
		JPanel panel_top = new JPanel();
		
		panel_top.setBackground(Manager.dark);
		panel_top.setBorder(null);
		panel_top.setBounds(0, 0, 1280, 55);
		
		getContentPane().add(panel_top);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panel_west.setBackground(blue);
		panel_west.setSize(new Dimension((int) ((double) this.getWidth() * 0.27), this.getHeight()));
		
		
		JScrollPane group_scroll = new JScrollPane();
		group_scroll.setBounds(10, panel_top.getHeight() + 10, panel_west.getWidth() - 10, getHeight() - 10);
		group_model = new DefaultListModel<>();
		group_list = new JList<>(group_model);
		group_scroll.setViewportView(group_list);
		
		initGroups();
		
		getContentPane().add(panel_west);
		
		
		panel_east.setBackground(Manager.ct.getBackground());
		panel_east.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		
		
		
		
		getContentPane().add(panel_east);
	}
	
	public void selectGroup(Chat chat) {
		messages = Loader.messages;
		//Show Messagesg
	}
	
	//NOT SHOWING YET
	public void initGroups() {
		groups.add(new Group(213, "Hey", new ArrayList<>()));
		for(Group group : groups) {
			group_model.addElement(new Chat(group));
		}
	}
	
	public void refreshGroups() {
		groups = Loader.groups;
		initGroups();
	}
	
	class Chat extends JButton {

		private static final long serialVersionUID = 1L;
		public Group group;
		
		
		public Chat(Group group) {
			this.group = group;
			setSize(300, 50);
			
			setFocusPainted(false);
			setText(group.groupname);
			setFont(new Font("Tahoma", Font.PLAIN, 24));
			setForeground(Manager.ct.getForeground());
			setBackground(Manager.ct.getBackground());
			setBorder(new MatteBorder(0, 0, 1, 0, Manager.ct.getForeground()));
		}
		
	}
}
