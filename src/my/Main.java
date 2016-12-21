package my;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dummy dumy=new  Dummy("String");//
		Object o = dumy.results.get(0).get("coloumn1");
		String a= (String) o;
		System.out.println(dumy.results);
		System.out.println(a);
		
	}

}
