package Activity5;

abstract class Book{
	String title;
	
	abstract void setTitle(String s);
	String getTitle() {
		return title;
	}
}
	
	class Bookie extends Book {
		public void setTitle(String s) {
		title = s;
	}

	}


public class Activity1 {
	
	public static void main(String[] args) {
		String title ="Life";
		
		Book Story = new Bookie ();
		
		Story.setTitle(title);
		System.out.println("Title is :" + Story.getTitle());
		
	}
}		
		
		
		


