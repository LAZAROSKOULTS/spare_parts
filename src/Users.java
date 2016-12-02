



public class Users {
	private int id=99;
	protected String username;
	protected Role role;
	
	
	
	public Users(String name,Role role){
		username=name;
		this.role=role;
		this.id=this.id+1;
		System.out.println("I create a user with name: "+this.username+" and this id: "+this.id+" !!");
	}
}
