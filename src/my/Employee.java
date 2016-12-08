package my;

import java.util.ArrayList;

public class Employee extends User{
	ArrayList<Object> kati;
	
	//Constractor
	public Employee(String name,String email) {
		username=name;
		this.email=email;
		role=new Role("Employee");
	}
	
	//Constractor for TESTS!
	public Employee(){}
}
