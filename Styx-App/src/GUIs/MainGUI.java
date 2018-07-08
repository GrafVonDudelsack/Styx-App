package GUIs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.Timestamp;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Main.Controller;
import Main.Main;
import SQLITE.Group;
import SQLITE.Loader;
import SQLITE.Message;
import SQLITE.User;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Color blue = Manager.blue;
	Color transparent = Manager.transparent;
	Color dark_shade = Manager.dark_shade;

	JPanel panel_east;
	JPanel panel_west;
	JPanel panel_top;
	JPanel panel_bottom;
	
	JLabel group_name;
	
	ArrayList<Group> groups;
	ArrayList<Message> messages;
	
	JScrollPane group_scroll;
	DefaultListModel<Object> group_model;
	JList<Object> group_list;
	
	JScrollPane msg_scroll;
	DefaultListModel<Object> msg_model;
	JList<Object> msg_list;
	
	JTextArea chat;
	JScrollPane chat_scroll;
	
	public void test() {
		for(int i = 0; i < 25; i++) {
			groups.add(new Group(i, "Group:" + i, new ArrayList<>()));
		}
		
		for(Group group : groups) {
			if(group.groupID != 0) {
				String abc = "Ich bin ein langer und unnötiger Text! ";
				String text = "";
				for(int i = 0; i < 87; i++) {
					text += abc;
					messages.add(new Message(new User(group.groupID, group.groupID + "", "", "", ""), group, new Timestamp(9237), text.getBytes(), ""));
				}
			}
		}
	}
	

	public MainGUI() {
        groups = Loader.groups;
		messages = Loader.messages;

		
		this.setSize(1280,720);
		this.setResizable(false);
		
		panel_bottom = new JPanel();
		panel_top = new JPanel();
		panel_west = new JPanel();
		panel_east = new JPanel();
		
		
		panel_top.setBackground(Manager.dark);
		panel_top.setBorder(null);
		panel_top.setBounds(0, 0, 1280, 55);
		
		panel_west.setBackground(blue);
		panel_west.setBounds(0, panel_top.getHeight(),(int) ((double) this.getWidth() * 0.3), this.getHeight() - panel_top.getHeight());
		
		panel_east.setBackground(Manager.ct.getBackground());
		panel_east.setBounds(panel_west.getWidth(), panel_west.getY(), (this.getWidth() - panel_west.getWidth()), this.getHeight() - 70 - 30 - panel_top.getHeight());
		
		JButton new_group = new JButton();
		new_group.setBounds(0, 0, 50, 50);
		new_group.setBorderPainted(false);
		new_group.setFocusPainted(false);
		new_group.setBackground(Manager.dark);
		new_group.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager.changeJFrame("create");
			}
		});
		new_group.setIcon(new ImageIcon(MainGUI.class.getResource("/GUIs/create.png")));
		getContentPane().add(new_group);
		
		group_name = new JLabel("");
		group_name.setFont(new Font("Lucida Sans Unicode", 0, 26));
		group_name.setBounds(panel_east.getX() + 5, 0, 300, 55);
		group_name.setBorder(new EmptyBorder(0, 0, 0, 0));
		group_name.setBackground(transparent);
		group_name.setForeground(Manager.light_gray);
		getContentPane().add(group_name);
		
		getContentPane().add(panel_top);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		test();
		
		group_model = new DefaultListModel<>();
		initGroups();
		group_list = new JList<>(group_model);
		group_list.setBackground(blue);
		group_list.setBorder(new MatteBorder(0, 0, 0, 0, transparent));
		group_list.setCellRenderer(new ChatCellRenderer());
		group_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		group_list.setLayoutOrientation(JList.VERTICAL);
		group_scroll = new JScrollPane(group_list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		group_scroll.setBorder(new MatteBorder(0, 0, 0, 0, transparent));
		group_scroll.setBackground(blue);
		group_scroll.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		group_scroll.setPreferredSize(new Dimension(panel_west.getWidth() - 10, 700));
		panel_west.add(group_scroll);
		
		
		getContentPane().add(panel_west);
		
		getContentPane().add(panel_east);

		/*msg_model = new DefaultListModel<>();
		msg_list = new JList<>(msg_model);
		msg_list.setBackground(Manager.ct.getBackground());
		msg_list.setLocation(panel_west.getWidth(), this.getHeight() - 70 - 30 - panel_top.getHeight());
		msg_list.setCellRenderer(new MsgCellRenderer());
		msg_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		msg_list.setLayoutOrientation(JList.VERTICAL);
		msg_list.setBorder(new MatteBorder(100, 0, 7, 0, Manager.ct.getBackground()));
		msg_list.setFixedCellHeight(-1);
		msg_scroll = new JScrollPane(msg_list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		msg_scroll.setBorder(new MatteBorder(0, 0, 0, 0, transparent));
		msg_scroll.setBackground(Manager.ct.getBackground());
		msg_scroll.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		msg_scroll.setLocation(panel_west.getWidth(), panel_top.getHeight());
		msg_scroll.setSize(new Dimension(this.getWidth() - panel_west.getWidth(), this.getHeight() - 70 - 30 - panel_top.getHeight()));
		getContentPane().add(msg_scroll);*/
		
		chat = new JTextArea();
		chat.setEditable(false);
		chat.setVisible(true);
		chat.setWrapStyleWord(true);
		chat.setLineWrap(true);
		chat.setBounds(panel_west.getWidth(), panel_top.getHeight(), (this.getWidth() - panel_west.getWidth()), this.getHeight() - 70 - panel_top.getHeight());
		chat.setBackground(Manager.ct.getBackground());
		chat.setForeground(Manager.ct.getForeground());
		chat.setFont(new Font("Lucida Sans Unicode", 0, 18));
		chat_scroll = new JScrollPane(chat);
		chat_scroll.setBounds(panel_west.getWidth(), panel_top.getHeight(), (this.getWidth() - panel_west.getWidth()), this.getHeight() - 70 - panel_top.getHeight());
		getContentPane().add(chat_scroll);
		
		panel_bottom.setBackground(Manager.dark);
		panel_bottom.setBounds(panel_west.getWidth(), this.getHeight() - 70 , (this.getWidth() - panel_west.getWidth()), 70);
		
		
		JTextArea input = new JTextArea();
		input.setEditable(true);
		input.setText("");
		input.setFont(new Font("Lucida Sans Unicode", 0, 20));
		input.setForeground(Manager.darkest);
		input.setBackground(Manager.white);
		input.setToolTipText("Enter Message");
		input.setBounds(panel_bottom.getX() + 5, panel_bottom.getY() + 5, panel_bottom.getWidth() - 50 - 15, 55);
		JScrollPane input_scroll = new JScrollPane(input, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		input_scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		input_scroll.setForeground(Manager.darkest);
		input_scroll.setBackground(Manager.white);
		input_scroll.setPreferredSize(new Dimension(panel_bottom.getWidth() - 50 - 15, 60));
		input_scroll.setBounds(panel_bottom.getX() + 5, panel_bottom.getY() + 5, panel_bottom.getWidth() - 50 - 15, 60);
		
		getContentPane().add(input_scroll);
		
		JButton send = new JButton();
		send.setIcon(new ImageIcon(MainGUI.class.getResource("/GUIs/send.png")));
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Loader.activeGroup != null) {
					String msg = input.getText().trim();
					if(msg.isEmpty()) {
						input.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
						return;
					}else {
						input.setBorder(new MatteBorder(0, 0, 0, 0, panel_bottom.getBackground()));
					}
					
					String s = Loader.getUserByID(Main.activeUserID).userID + ":";
					chat.append("\n" + s + "\n" + msg + "\n");
					
					Controller.sendMessage(Loader.activeGroup, msg);
				}
			}
		});
		send.setBorderPainted(false);
		send.setFocusPainted(false);
		send.setBackground(transparent);
		send.setForeground(transparent);
		send.setBounds(input.getX() + input.getWidth() + 2, input.getY() + 5, 50, 50);
		
		getContentPane().add(send);
		
		getContentPane().add(panel_bottom);
		
		JPanel ignore = new JPanel();
		ignore.setBackground(panel_east.getBackground());
		getContentPane().add(ignore);
	}
	
	public void initGroups() {
		int count = 0;
		group_model.removeAllElements();
		for(Group group : groups) {
			if(group != null) {
				group_model.addElement(new Chat(group));
				count ++;
			} else {
				System.out.println("ERROR");
			}
		}
		
		if(count == 0) {
			group_model.addElement("\n\nDu bist in keiner Gruppe!\n\n\n\n");
		}
	}
	
	public void refreshGroups() {
		groups = Loader.groups;
		initGroups();
	}
	
	public void addMessage(Message msg) {
		if(msg != null) {
			String s = msg.Sender.forename + " " + msg.Sender.lastname + ":";
			chat.append("\n" + s + "\n" + new String(msg.message) + "\n");
			chat_scroll.getVerticalScrollBar().setValue(chat_scroll.getVerticalScrollBar().getMaximum());
		} else {
			System.out.println("ERROR");
		}
	}
	
	public void initMessages(Group group) {
		int count = 0;
		chat.setText("");
		for(Message msg : messages) {
			if(msg != null) {
				if(msg.Group.groupID == group.groupID) {
					String s = msg.Sender.forename + " " + msg.Sender.lastname + ":";
					chat.append("\n" + s + "\n" + new String(msg.message) + "\n");
					count ++;
				}
			} else {
				System.out.println("ERROR");
			}
		}
		chat_scroll.getVerticalScrollBar().setValue(chat_scroll.getVerticalScrollBar().getMaximum());
		group_name.setText(group.groupname);
		
		if(count == 0) {
			chat.append("\n\n          Die Gruppe \"" + group.groupname + "\" wurde erstellt!\n\n\n\n");
			return;
		}
		Loader.activeGroup = group;
	}
	
	public void refreshMessages() {
		messages = Loader.messages;
		if(Loader.activeGroup != null) {
			initMessages(Loader.activeGroup);
		}
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public class Chat {

		public Group group;
		
		
		public Chat(Group group) {
			this.group = group;
		}
		
	}
		
	public class ChatCellRenderer extends JButton implements ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;
		public Chat chat;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			if(value instanceof Chat) {
			
				chat = (Chat) value;
				Group group = chat.group;
				
				this.setText(group.groupname);
				this.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/chat_icon.png")));
				this.setIconTextGap(8);
				this.setOpaque(true);
				this.setMinimumSize(new Dimension(panel_west.getWidth() - 10, 51));
				this.setHorizontalAlignment(SwingConstants.LEFT);
				this.setFocusPainted(false);
				this.setBorder(new MatteBorder(0, 0, 1, 0, Manager.ct.getForeground()));
				this.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 28));
				
				if(isSelected) {
					initMessages(group);
					this.setForeground(Manager.darkest);
					this.setBackground(blue);
					this.setBackground(Manager.bright_shade);
				}else {
					this.setForeground(Manager.white);
					this.setBackground(blue);
				}
			}
			
			return this;
		}
		
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public class Msg {
		public Message message;
		public User user;
		
		public Msg(Message message) {
			this.message = message;
			this.user = this.message.Sender;
		}
	}
	
	/*public class MsgCellRenderer extends JPanel implements ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			isSelected = false;
			
			this.setLayout(null);
			
			if(value instanceof Msg) {
				
				Msg msg = (Msg) value;
				Message message = msg.message;
				User user = msg.user;
				
				JLabel sender;
				JTextArea text;
				
				this.setMinimumSize(new Dimension(100, list.getFixedCellWidth()));
				this.setOpaque(true);
				
				if(message.type.equalsIgnoreCase("")) {
					
					sender = new JLabel(user.forename + " " + user.lastname);
					sender.setBorder(new EmptyBorder(0, 0, 0, 0));
					sender.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 22));
					sender.setBounds(5, 5, list.getFixedCellWidth() - 10, 50);
					
					text = new JTextArea(new String(message.message));
					text.setBorder(new EmptyBorder(0, 0, 0, 0));
					text.setLocation(5, sender.getY() + sender.getHeight() + 5);
					text.setMinimumSize(new Dimension(list.getFixedCellWidth() - 10, 50));
					text.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
					text.setEditable(false);
					text.setLineWrap(true);
					text.setWrapStyleWord(true);
					
					if(Main.activeUserID == user.userID) {
						this.setBackground(blue);
						sender.setForeground(Manager.white);
						text.setForeground(Manager.white);
						sender.setBackground(Manager.blue);
						text.setBackground(Manager.blue);
					}else {
						this.setBackground(Manager.darkest);
						sender.setForeground(Manager.darkest);
						text.setForeground(Manager.darkest);
						sender.setBackground(Manager.light_gray);
						text.setBackground(Manager.light_gray);
					}
					
					this.add(sender);
					this.add(text);
					
					
				}else {
					//Später: Dateien
				}
			}
			
			return this;
		}
		
	}*/
	
	/*public class MsgCellRenderer extends JTextArea implements ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			isSelected = false;
			
			this.setLayout(null);
			
			if(value instanceof Msg) {
				
				Msg msg = (Msg) value;
				Message message = msg.message;
				User user = msg.user;
				
				this.setMinimumSize(new Dimension(list.getFixedCellWidth(), 100));
				this.setBorder(new MatteBorder(0, 0, 1, 0, Manager.ct.getForeground()));
				
				if(message.type.equalsIgnoreCase("")) {
					
					String name = user.forename + " " + user.lastname + ":";
					String m = new String(message.message);
					this.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
					this.setText(name + "\n" + m);
					this.setEditable(false);
					this.setWrapStyleWord(true);
					this.setLineWrap(true);
					this.setBackground(Manager.ct.getBackground());
					
					if(Main.activeUserID == user.userID) {
						this.setForeground(Color.WHITE);
						this.setBackground(blue);
					}else {
						this.setForeground(Manager.darkest);
						this.setBackground(Manager.light_gray);
					}
					
				}else {
					//Später: Dateien
				}
			}
			
			return this;
		}
		
	}*/
}
