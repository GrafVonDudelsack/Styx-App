package SQLITE;

import java.sql.Timestamp;

public class Message {
	
	public Integer SenderID;
	public Integer GroupID; 
	public Timestamp Time;
	public byte[] message; 
	public String type;
	
	public Message(Integer SenderID, Integer GroupID, Timestamp Time, byte[] message, String type) {
		this.SenderID = SenderID;
		this.GroupID = GroupID;
		this.Time = Time;
		this.message = message;
		this.type = type;
	}
	
}
