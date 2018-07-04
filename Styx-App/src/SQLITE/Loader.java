package SQLITE;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Loader {
	
	public static ArrayList<Message> messages;
	protected static ArrayList<User> users;
	public static ArrayList<Group> groups;
	
	public static Group activeGroup;
	
	public static void init() {
		activeGroup = null;
		
		messages = new ArrayList<>();
		
		users = Manager.getAllUserData();
		groups = Manager.getAllGroupData();
		
	}
	
	public static User getUserByID(Integer ID) {
		User user = null;
		
		for(User u : users) {
			if(u.userID == ID) {
				user = u;
			}
		}
		
		return user;
	}
	
	public static Group getGroupByID(Integer ID) {
		Group group = null;
		
		for(Group g : groups) {
			if(g.groupID== ID) {
				group = g;
			}
		}
		
		return group;
	}
	
	public static void addMessage(User sender, Group group, Timestamp time, byte[] message, String type) {
		messages.add(new Message(sender, group, time, message, type));
	}
	
	public static void addGroup(Integer groupID, String groupname, ArrayList<User> users) {
		groups.add(new Group(groupID, groupname, users));
	}
	
	public static void addUser(Integer userID, String forename, String lastname, String status, String email) {
		users.add(new User(userID, forename, lastname, status, email));
	}
	
}
