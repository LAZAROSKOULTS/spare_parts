package my;
import java.util.ArrayList;

public class Database {
	static ArrayList<User> Users;
	static ArrayList<Service> Services;
	static ArrayList<SparePart> SpareParts;
	static ArrayList<Transaction> Transactions;
	
	public Database() {
	}

	static public ArrayList<User> getUsers(){
		return Users;
	}
	
	static boolean SaveUsers(){
		return true;
	}
	
	static boolean NewUser(User nu){
		return true;
	}
	static public ArrayList<Transaction> getTransactions(){
	return Transactions;
	}
	
	static public void getTranIdCostEdate(ArrayList<String> tran){
	
	}
	
}
