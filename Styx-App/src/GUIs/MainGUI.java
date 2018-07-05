package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import SQLITE.Group;
import SQLITE.Loader;
import SQLITE.Message;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Color blue = Manager.blue;
	Color transparent = Manager.transparent;
	Color dark_shade = Manager.dark_shade;
	
	JPanel panel_west = new JPanel();
	JPanel panel_east = new JPanel();
	JPanel panel_top = new JPanel();
	
	ArrayList<Group> groups;
	ArrayList<Message> messages;
	
	JScrollPane group_scroll;
	DefaultListModel<Object> group_model;
	JList<Object> group_list;
	
	public void test() {
		groups.add(new Group(213, "Gruppe 1", new ArrayList<>()));
		groups.add(new Group(213, "Q11", new ArrayList<>()));
		groups.add(new Group(213, "Aplenüberquerung", new ArrayList<>()));
		groups.add(new Group(213, "Was geht", new ArrayList<>()));
		groups.add(new Group(213, "MTB", new ArrayList<>()));
		groups.add(new Group(213, "Mama", new ArrayList<>()));
		groups.add(new Group(213, "Gruppe 2", new ArrayList<>()));
		groups.add(new Group(213, "Test", new ArrayList<>()));
		groups.add(new Group(213, "Hey", new ArrayList<>()));
		groups.add(new Group(213, "LoL", new ArrayList<>()));
		groups.add(new Group(213, "Gaming", new ArrayList<>()));
		groups.add(new Group(213, "Overwatch", new ArrayList<>()));
		groups.add(new Group(213, "Styx", new ArrayList<>()));
		groups.add(new Group(213, "Ui", new ArrayList<>()));
		groups.add(new Group(213, "I/O Group", new ArrayList<>()));
		groups.add(new Group(213, "Client", new ArrayList<>()));
		groups.add(new Group(213, "Server", new ArrayList<>()));
		groups.add(new Group(213, "Olee", new ArrayList<>()));
		groups.add(new Group(213, "Finale", new ArrayList<>()));
	}
	

	public MainGUI() {
        groups = Loader.groups;
		messages = Loader.messages;

		
		this.setSize(1280,720);
		this.setResizable(false);
		
		
		panel_top.setBackground(Manager.dark);
		panel_top.setBorder(null);
		panel_top.setBounds(0, 0, 1280, 55);
		
		getContentPane().add(panel_top);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panel_west.setBackground(blue);
		panel_west.setBounds(0, panel_top.getHeight(),(int) ((double) this.getWidth() * 0.27), this.getHeight());
		
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
		panel_west.add(group_scroll, BorderLayout.LINE_START);
		
		
		getContentPane().add(panel_west);
		
		
		panel_east.setBackground(Manager.ct.getBackground());
		panel_east.setBounds(panel_west.getWidth(), panel_top.getHeight(), this.getWidth(), this.getHeight());
		
		
		getContentPane().add(panel_east);
	}
	
	public void selectGroup(Chat chat) {
		messages = Loader.messages;
		//Show Messages
	}
	
	public void initGroups() {
		int count = 0;
		for(Group group : groups) {
			if(group != null) {
				group_model.addElement(new Chat(group));
				count ++;
			} else {
				System.out.println("ERROR");
			}
		}
		
		if(count == 0) {
			System.out.println("No groups");
		}
	}
	
	public void refreshGroups() {
		groups = Loader.groups;
		initGroups();
	}
	
	public class Chat {

		public Group group;
		
		
		public Chat(Group group) {
			this.group = group;
		}
		
	}
	
	public class ChatCellRenderer extends JButton implements ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
			if(value instanceof Chat) {
			
				Chat chat = (Chat) value;
				Group group = chat.group;
				
				this.setText(group.groupname);
				this.setIcon(new ImageIcon(Manager.class.getResource("/GUIs/chat_icon.png")));
				this.setIconTextGap(5);
				this.setOpaque(true);
				this.setMinimumSize(new Dimension(panel_west.getWidth() - 10, 51));
				this.setHorizontalAlignment(SwingConstants.LEFT);
				this.setFocusPainted(false);
				this.setBorder(new MatteBorder(0, 0, 1, 0, Manager.ct.getForeground()));
				this.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 32));
				
				if(isSelected) {
					this.setForeground(Manager.dark);
					this.setBackground(blue);
					this.setBackground(Manager.bright_shade);
				}else {
					this.setForeground(Manager.dark);
					this.setBackground(blue);
				}
			}
			
			return this;
		}
		
	}
}
