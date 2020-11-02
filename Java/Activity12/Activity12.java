package Activity12;

import java.util.*;

public class Activity12 {
	public static void main(String[] args) {
		
	Deque<String> dq = new LinkedList<String>();
	
	dq.add("Tiger");
	dq.add("Lion");
	dq.add("Wolf");
	dq.add("Elephant");
	dq.add("Deer");
	dq.add("Cheetah");
	
	Iterator<String> iterator = dq.iterator();
	while (iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	
	System.out.println("Peek first: " + dq.peekFirst());
	System.out.println("Peek last: " + dq.peekLast());
	
	System.out.println("Wolf Present: " + dq.contains("Wolf"));
	
	dq.removeFirst();
	dq.removeLast();
	
	System.out.println("Queuelist : " + dq);
	System.out.println("Queuesize : " + dq.size());
	
}
	}



