package my;
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;//Fix for Serializable warning...
	protected int id=99;
	protected String username;
	protected String email;
	protected Role role;
	
	
	public User(){
		this.id=this.id+1;
	}
	
	
	public int getId(){
		return id;
	}
	public String getUsername(){
		return username;
	}
	public String getEmail(){
		return email;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public Role getRole(){
		return role;
	}
	@Override
	public String toString(){
		return "Username: "+username+" Email: "+email+" Role: "+role;
		
	}
}
