package my;
import java.util.ArrayList;

public class Database {
	static ArrayList<User> Users;
	static ArrayList<Service> Services;
	static ArrayList<SparePart> SpareParts;
	
	public Database() {
	}

	static ArrayList<User> getUsers(){
		return Users;
	}
	
	static boolean SaveUsers(){
		return true;
	}
	
	static boolean NewUser(User nu){
		return true;
	}
}
