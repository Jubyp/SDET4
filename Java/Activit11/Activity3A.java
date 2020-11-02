package Activit11;

import java.util.LinkedList;
import java.util.*;

import java.util.Queue;

public class Activity3A {

	public static void main(String[] args) {
		
		        Queue<Integer> q = new LinkedList<>();

		        
		        for (int i=0;i<5;i++) {
		            q.add(i); 
		            
		        }

		        System.out.println("Elements in queue: " + q);

		       
		        int remove = q.remove();
		        System.out.println("removed element: " + remove);

		        
		        int head = q.peek();
		        System.out.println("head of queue: " + head);

		        int size = q.size();
		        System.out.println("Size of queue: " + size);
		        System.out.println("Elements in queue: " + q);
		    }
		

	}



