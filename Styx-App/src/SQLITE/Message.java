package SQLITE;

import java.sql.Timestamp;

public class Message {
	
	public User Sender;
	public Group Group; 
	public Timestamp Time;
	public byte[] message; 
	public String type;
	/**
	 * type = "" -> String
	 * type = ".data" -> .data-Datei //Noch nicht implementiert
	 */
	
	
	public Message(User Sender, Group Group, Timestamp Time, byte[] message, String type) {
		this.Sender = Sender;
		this.Group = Group;
		this.Time = Time;
		this.message = message;
		this.type = type;
	}
	
}
