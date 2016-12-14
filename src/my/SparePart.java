package my;

import java.util.ArrayList;

public class SparePart {

	
		String name;
		String constructor;
		ArrayList<String> compatible_cars;
		int price;
		String type;
		int reserve;
	
	
	public SparePart(String name,String constructor_name,ArrayList<String> cars,int price,String type){
		if (type=="new" || type == "second hand"){
			this.name=name;
			constructor=constructor_name;
		
			compatible_cars = new ArrayList<String>();
			for (String car : cars){
				compatible_cars.add(car);
			}
		
			this.price=price;
		
		}else{
			System.out.println("Type has to be: \"new\" or \"second hand\"!");
		}
	}
	
	@Override
	public String toString(){
		return "Product name:"+name+"\n Constructor name:"+constructor+"\n Cars:"+compatible_cars+"\n Price"+price+type;
	}
	
}
