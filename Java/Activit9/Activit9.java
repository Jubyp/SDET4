package Activit9;

import java.util.ArrayList;

public class Activit9 {

	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("John");
		arr.add("Sid");
		arr.add("Dan");
		arr.add("Mike");
		
		for (String s:arr) {
		 System.out.println(s);
		}
		
		 System.out.println(arr.get(2));
		 System.out.println("Is Dan in list :" +arr.contains("Dan"));
		 System.out.println("Size = " +arr.size());
	
		 arr.remove(3);
		 System.out.println("New Size = " +arr.size());
		
	}

}
