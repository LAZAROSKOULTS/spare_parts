package my;
public class Role {
	private String rolename;
	private int id;
	/* ID is a quick way to know the role e.g.
	 *consumers has id=1,Employee has id=2...Maybe useless...*/
	

	public Role(String name) {
		rolename=name;
		if(name.equals("Customer")){
			id=5;
		}else if(name.equals("Employee")){
			id=4;
		}else if(name.equals("Partinent")){
			id=3;
		}else if(name.equals("Storekeeper")){
			id=2;
		}
	}
	public String getRolename(){
		return this.rolename;
	}
	public int getId(){
		return id;
	}
}
