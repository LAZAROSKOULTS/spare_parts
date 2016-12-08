package my;

import java.util.ArrayList;

public class Partinent extends User{
	ArrayList<Object> list;
	
	public Partinent(String name,String email) {
		username=name;
		this.email=email;
		role=new Role("Partinent");
	}
	
	//Constractor for tests!
	public Partinent (){}
}
