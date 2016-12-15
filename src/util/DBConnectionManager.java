package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	
	private Connection connection;
	private ResultSet rs;
	private Statement stmt;
	
	public DBConnectionManager(String dbURL, String user, String pwd) {
		try {
            //Check if driver exists.
			Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem with SQL connection. Driver does not exist!");
            return;
        }
		try {
			this.connection = DriverManager.getConnection(dbURL, user, pwd);
        } catch (SQLException ex) {
            System.out.println("Problem with SQL connection. Could not connect to DB!");
            return;
        }
	}

	//Get connection (if directly needed (for context and/or prepared statements))
	public Connection getConnection() {
        return this.connection;
	}
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
	//Close connection using the manager!
	public void close(){
		try {
			connection.close();
			System.out.println("DB Connection closed successfully!");
		} catch (SQLException e) {
			System.out.println("Problem while closing connection!");
			e.printStackTrace();
		}
	}
}
