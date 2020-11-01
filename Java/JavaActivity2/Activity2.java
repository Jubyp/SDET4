package JavaActivity2;

import java.util.Arrays;
import java.util.*;

public class Activity2 {

	public static void main(String[] args) {
		
	int [] Numb = {10,77,10,54,-11,10};
	
	int x= 10;
	int y= 30;
	
	System.out.println("Array is:" + Arrays.toString(Numb));
	System.out.println("Result is:" + result(Numb,x,y));
	}
	
  public static boolean result(int [] Numb , int x, int y) {
	
	int temp = 0;
	
	for( int number: Numb) {
		if (number == x) {
		temp += x;
	}
	
	if (temp > y) {
			break;
	
  }
	}
  return temp == y; 
		
	}   
	
  }


  


