package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


//Handles the queries!!!
public class DBHandler {
	private Connection connection;
	//private ResultSet rs;
	//private Statement stmt;
	
	
	//get connection outside it...
	public DBHandler(Connection conn){
		this.connection = conn;
	}
	
	//Start from here
	//Execute a query that doesn't return results!
	public void execute(String sql){
		
	}
	
	//Get results from db.
	public ArrayList<HashMap<String, Object>> getQuery(String sql){
		
	}
	
	private void fetch(ResultSet rs, ArrayList<HashMap<String, Object>> results){
		
	}
	
	//OLD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
