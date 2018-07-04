package SQLITE;

import java.util.ArrayList;

public class Group {
	
	public Integer groupID;
	public String groupname;
	public ArrayList<User> users;
	
	public Group(Integer groupID, String groupname, ArrayList<User> users) {
		this.groupID = groupID;
		this.groupname = groupname;
		this.users = users;
	}
	
}
