package my;
import java.util.ArrayList;

public class Storekeeper extends User{

	ArrayList<SparePart> Storage;
	
	//Constractor!
	public Storekeeper(String name,String email) {//To be continued...
		username=name;
		this.email=email;
		role = new Role("Storekeeper");
		Storage = new ArrayList<SparePart>();//Storage = Database.getStorage();
	}


	//Constractor for TESTS!
	public Storekeeper(){}
}