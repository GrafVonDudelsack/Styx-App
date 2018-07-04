package SQLITE;

public class User {
	
	public Integer userID;
	public String forename, lastname, status, email;
	
	public User(Integer userID, String forename, String lastname, String status, String email) {
		this.userID = userID;
		this.forename = forename;
		this.lastname = lastname;
		this.status = status;
		this.email = email;
	}
}
