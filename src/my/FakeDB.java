package my;

import java.util.ArrayList;

public class FakeDB extends Database{
	
	public FakeDB(){
		makeUsers();
		makeServices();
		makeSpareParts();
		makeTransactions();
	}

	private ArrayList<User> makeUsers(){
		Users=new ArrayList<User>();
		for(int i=0;i<10;i++){
			User laz= new User();
			laz.setUsername("Koulaz");
			Users.add(laz);
		}
		return Users;
	}

	private ArrayList<Service> makeServices(){
		Services = new ArrayList<Service>();
		for(int i=0;i<5;i++){
		Service a = new Service();
		Services.add(a);
		}
		return Services;
	}

	private ArrayList<SparePart> makeSpareParts(){
		SpareParts =new ArrayList<SparePart>();
		for (int i=0;i<50;i++){
			ArrayList<String> a=new ArrayList<String>();
			a.add("BWM M3");
			SparePart pa = new SparePart("sa","germany",a,1000,"new");
			SpareParts.add(pa);
		}
		return SpareParts;
	}
	private ArrayList<Transaction> makeTransactions(){
		Transactions = new ArrayList<Transaction>();
		for (int i=0;i<10;i++){
			Transaction a=new Transaction();
			Transactions.add(a);
		}
		return Transactions;
				
	}
}
