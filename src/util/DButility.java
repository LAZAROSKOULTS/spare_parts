package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public final class DButility {
	
	private Connection connection;
	
	public DButility(String dbURL, String user, String pwd) {
		try {
            //Check if driver exists.
			Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem with SQL connection. Driver does not exist!");
            return;//Abort creation!
        }
		int i = 0;
		while(this.connection == null && i < 5){//Five tries to connect to db...
			System.out.println("Trying to connect to db: "+ i);
			try {
				this.connection = DriverManager.getConnection(dbURL, user, pwd);
	        } catch (SQLException ex) {
	            System.out.println("Problem with SQL connection. Could not connect to DB!");
	            this.close();//Might generate a second sql exception!
	        }
		}
	}
	//Get connection (if directly needed (for context and/or prepared statements))
	public Connection getConnection() {
        return this.connection;
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
