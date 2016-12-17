package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Handles the queries!!!
public class DBHandler {
	//CAREFUL EVERYTHING IS NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!FIX IT!
	private Connection connection;
	private ResultSet rs;
	private Statement stmt;
	
	
	//Execute an sql query, get result set (for simple statements)
	public ResultSet execQuery(String query){
		//If there are leftovers, clean them.
		if(this.rs != null || this.stmt != null){
			this.cleanup();
		}
		try {
			this.stmt = connection.createStatement();
			this.rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Problem while executing query!");
			e.printStackTrace();
		}
		return rs;
	}
	//Cleanup, used only after execQuery
	public void cleanup(){
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Problem while cleaning up!");
			e.printStackTrace();
		}  
	}
}
