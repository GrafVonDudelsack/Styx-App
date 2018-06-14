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
	
	public static ArrayList<String> getUserData(Integer UserID) {
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
	}
	
	
	public static void addMessage(Integer SenderID, Integer GroupID, Timestamp Time, byte[] message, String type) {
		sqlite.update("INSERT INTO Messages (SENDER_ID, GROUP_ID, TIME, MESSAGE, TYPE) VALUES ('" + SenderID + "', '" + GroupID + "', '" + Time + "', '" + message + "', '" + type + "')");
	}
	
	public static ArrayList<Message> getMessages(Integer GroupID) {
		ArrayList<Message> messages = new ArrayList<>();
		ResultSet rs = sqlite.getResult("SELECT * FROM Messages WHERE GROUP_ID = '" + GroupID + "' ORDER BY ID DESC'");
		ResultSet rs2 = sqlite.getResult("SELECT * FROM MESSAGES WHERE GROUP_ID = '" + GroupID + "'");
		
		try {
			
			if(rs.next() && rs2.next()) {
				rs.beforeFirst();
				rs.first();
				rs2.beforeFirst();
				rs2.next();
				
				Integer SenderID = rs.getInt("SENDER_ID");
				Message message = new Message(SenderID, GroupID, rs.getTimestamp("TIME"), rs.getBytes("MESSAGE"), rs.getString("TYPE"));
				messages.add(message);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messages;
	}
	
	public static ArrayList<Integer> getAllGroupIDs() {
		ResultSet rs = sqlite.getResult("SELECT GROUP_ID GROM Users");
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
	
}
