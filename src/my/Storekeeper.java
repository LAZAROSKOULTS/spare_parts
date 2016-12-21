package my;
import java.util.ArrayList;

public class Storekeeper extends User{

	ArrayList<SparePart> Storage;
	
	//Constructor!
	public Storekeeper(String name,String email) {//To be continued...
		username=name;
		this.email=email;
		role = "Storekeeper";
		Storage = new ArrayList<SparePart>();//Storage = Database.getStorage();
	}


	//Constructor for TESTS!
	public Storekeeper(){}
}