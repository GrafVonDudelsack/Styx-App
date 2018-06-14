package SQLITE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLITE {
	
	public Connection con = null;
	
	public void connect() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:styx.db");
			
			createTable("Users", "USER_ID INT, FORENAME VARCHAR(100), NAME VARCHAR(100), STATUS VARCHAR(100), EMAIL VARCHAR(100)");
			createTable("groups_users", "USER_ID, GROUP_ID, GROUP_NAME");
			createTable("Messages", "ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, SENDER_ID INT, GROUP_ID INT, TIME TIMESTAMP, MESSAGE LONGBLOB, TYPE VARCHAR(100)");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
   
    public boolean isConnected() {
        return con != null;
    }
   
    public void createTable(String name, String table) {
    	if(isConnected()) {
	        try {
	            con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS " + name + " (" + table + ");");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
    	}
    }
 
    public void update(String qry) {
    	if(isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    public ResultSet getResult(String qry) {
    	if(isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
}
