/**
 * 
 */
package com.amazon.linkedlist;

/**
 * @author Dany
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new LinkedListTest().testLinkedList();
	}
	
	public void testLinkedList()
	{
		LinkedListT<Integer, Integer> list=new LinkedListT<Integer, Integer>();
		list.put(2, 3);
		list.put(4, 7);
		list.put(5, 8);
		//list.iterateList();
		
		// for (Integer s : list) 
	      //      System.out.println(s);
		 
		 // print out all key-value pairs
	        for (Integer s : list)
	            System.out.println(s + " " + list.get(s));
	}

}
