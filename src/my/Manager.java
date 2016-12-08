package my;
import java.util.ArrayList;

public class Manager {

	
	public Manager() {
	}

	public ArrayList<User> getUsers(){
		return Database.getUsers();
	}
	
	
}
