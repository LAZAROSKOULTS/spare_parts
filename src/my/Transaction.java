package my;

import java.util.ArrayList;

public class Transaction {
	int costumer_id;
	int employee_id;
	int id;
	ArrayList<SparePart> list;
	int cost;
	String entry_date;
	String estimated_date;
	
	

	public Transaction() {
		// TODO Auto-generated constructor stub
		entry_date="0";
	}

	@Override
	public String toString(){
		return "The costomer_id: "+costumer_id+". The emloyee_id: "+employee_id+".\n";
	}
}
