package my;

import java.util.ArrayList;

public class Transaction {
	int costumer_id;
	int employee_id;
	ArrayList<SparePart> list;
	int cost;
	int delay;
	

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString(){
		return "The costomer_id: "+costumer_id+". The emloyee_id: "+employee_id+".\n";
	}
}
