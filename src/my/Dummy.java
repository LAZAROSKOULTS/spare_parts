package my;

import java.util.ArrayList;
import java.util.HashMap;

public class Dummy {
	public ArrayList<HashMap<String,Object>> results;
	public Dummy(String type) {
		results = new ArrayList<HashMap<String,Object>>();
		for(int i = 0 ; i<10 ; i++){
			HashMap row = new HashMap<String,Object>();
			for(int j = 0; j<5 ; j++){
				String colName = "coloumn" + j;
				if(type=="String"){				
					String value =  i+" " ;
					row.put(colName,value);
				}else if(type=="int"){
					int value = i*10 + j;
					row.put(colName,value);
				}else{
					Object object = new Object();
					row.put(colName,object);
				}
			}
			results.add(row);
			
		}
	}

}
