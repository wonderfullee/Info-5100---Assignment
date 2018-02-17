package Assignment4;

import java.util.HashMap;

public class Hashmap {
	private int [] arr;
	
	public void setArr(int [] arr){
		this.arr = arr;
	}
	
	public void hashMaping() {
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < arr.length; i++) { //this loop run N times
			map.put(arr[i], i);
		}
		
		for(int key : map.keySet()) {//this loop run N times
			System.out.print(key);
		}
		
		map.remove(6);
		map.remove(8);
		
		System.out.println();
		
		for(int key : map.keySet()) {//this loop run N times
			System.out.print(key);
		}
		
		System.out.println();
		System.out.println("hashmap has a 4 =  "+ map.containsKey(4));
	}

}
