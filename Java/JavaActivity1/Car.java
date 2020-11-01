package JavaActivity1;

public class Car {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String color;
		String transmission;
		int make;
		int tyres;
		int doors;
		
		Car() {
		tyres = 4;
		doors= 4;
		}	

 public void display() {
	 System.out.println("Make of Car: " +  make);
	 System.out.println("Transmission is: " +  transmission);
	 System.out.println("Color is: " +  color);
	 System.out.println("Tyres is: " +  tyres);
	 System.out.println("Doors is: " +  doors);
 }
	
 public void accelerate() {	
	 System.out.println("Car is moving "); 	

	}
 public void brake() {	
	 System.out.println("Car stopped "); 
 }
 }


