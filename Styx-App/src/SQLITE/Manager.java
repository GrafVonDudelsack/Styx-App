package SQLITE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Main.Main;

public class Manager {
	
	static SQLITE sqlite = Main.sqlite;
	
	public static void addUser(Integer UserID, String forename, String name, String status, String email) {
		sqlite.update("INSERT INTO Users (USER_ID, FORENAME, NAME, STATUS, EMAIL) VALUES ('" + UserID + "', '" + forename + "', '" + name + "', '" + status + "', '" + email + "')");
		Loader.addUser(UserID, forename, name, status, email);
	}
	
	public static void removeUser(Integer UserID) {
		sqlite.update("DELETE FROM Users WHERE USER_ID = '" + UserID + "'");
	}
	
	public static void updateUserName(Integer UserID, String forename, String name) {
		sqlite.update("UPDATE Users SET FORENAME = '" + forename + "' AND NAME = '" + name + "' WHERE USER_ID = '" + UserID + "'");
	}
	
	public static void updateUserStatus(Integer UserID, String status) {
		sqlite.update("UPDATE Users SET STATUS = '" + status + "' WHERE USER_ID = '" + UserID + "'");
	}
	
	public static void updateUserPicture() {
		
	}
	
	/*public static ArrayList<String> getUserData(Integer UserID) {
		ArrayList<String> data = new ArrayList<>();
		
		ResultSet rs = sqlite.getResult("SELECT * FROM Users WHERE USER_ID = '" + UserID + "'");
		
		try {
			if(rs.next()) {
				rs.beforeFirst();
				rs.first();
				
				data.add(rs.getString("FORENAME"));
				data.add(rs.getString("NAME"));
				data.add(rs.getString("STATUS"));
				data.add(rs.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static ArrayList<Integer> getAllUserIDs() {
		ResultSet rs = sqlite.getResult("SELECT USER_ID GROM Users");
		ArrayList<Integer> ids = new ArrayList<>();
		try {
			while(rs.next()) {
				ids.add(rs.getInt("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}*/
	
	public static ArrayList<User> getAllUserData() {
		ArrayList<User> data = new ArrayList<>();
		
		ResultSet rs = sqlite.getResult("SELECT * FROM Users");
		
		try {
			while(rs.next()) {
				User user = new User(rs.getInt("USER_ID"), rs.getString("FORENAME"), rs.getString("NAME"), rs.getString("STATUS"), rs.getString("EMAIL"));
				data.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	public static void addMessage(Integer SenderID, Integer GroupID, Timestamp Time, byte[] message, String type) {
		sqlite.update("INSERT INTO Messages (SENDER_ID, GROUP_ID, TIME, MESSAGE, TYPE) VALUES ('" + SenderID + "', '" + GroupID + "', '" + Time + "', '" + message + "', '" + type + "')");
		Loader.addMessage(Loader.getUserByID(SenderID), Loader.getGroupByID(GroupID), Time, message, type);
	}
	
	public static void addGroup(Integer groupID, String groupname, ArrayList<User> users) {
		for(User user : users) {
			sqlite.update("INSERT INTO groups_users (USER_ID, GROUP_ID, GROUP_NAME) VALUES ('" + user.userID + "', '" + groupID + "', '" + groupname + "')");
		}
		Loader.addGroup(groupID, groupname, users);
	}
	
	public static void removeGroup(Group group) {
		sqlite.update("DELETE FROM groups_users WHERE GROUP_ID = '" + group.groupID + "'");
	}
	
	public static void removeFromGroup(Group group, User user) {
		sqlite.update("DELETE FROM groups_users WHERE GROUP_ID = '" + group.groupID + "' AND USER_ID = '" + user.userID + "'");
	}
	
	public static ArrayList<Message> getAllMessages() {
		ArrayList<Message> data = new ArrayList<>();
		
		ResultSet rs = sqlite.getResult("SELECT * FROM Messages");
		
		try {
			while(rs.next()) {
				User user = Loader.getUserByID(rs.getInt("SENDER_ID"));
				Group group = Loader.getGroupByID(rs.getInt("GROUP_ID"));
				Timestamp time = rs.getTimestamp("TIM");
				byte[] msg = rs.getBytes("MESSAGE");
				String type = rs.getString("TYPE");
				
				Message message = new Message(user, group, time, msg, type);
				data.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static ArrayList<Integer> getAllGroupIDs() {
		ResultSet rs = sqlite.getResult("SELECT GROUP_ID FROM groups_users");
		ArrayList<Integer> ids = new ArrayList<>();
		try {
			while(rs.next()) {
				int id = rs.getInt("groups_users");
				if(!ids.contains(id)) {
					ids.add(id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	public static ArrayList<Group> getAllGroupData() {
		ArrayList<Group> data = new ArrayList<>();
		ArrayList<Integer> groupIDs = getAllGroupIDs();
		
		try {
			for(Integer id : groupIDs) {
				ResultSet rs = sqlite.getResult("SELECT * FROM groups_users WHERE GROUP_ID = '" + id + "'");
				String name = rs.getString("GROUP_NAME");
				ArrayList<User> users = new ArrayList<>();
				
				while(rs.next()) {
					users.add(Loader.getUserByID(rs.getInt("USER_ID")));
				}
				
				Group group = new Group(id, name, users);
				data.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
