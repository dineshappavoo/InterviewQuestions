/**
 * 
 */
package com.amazon.linkedlist;

import java.util.Iterator;

/**
 * @author Dany
 *
 */
public class LinkedListST<key, value> implements Iterable<key>{

	private int N;
	private Node first;
	
	private class Node
	{
		key key;
		int data;
		Node next;
	}

	@Override
	public Iterator<key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getSize()
	{
		return N;
	}
	
	public void put(key key, int data)
	{
		while(first!=null)
		{
			if(first.key==key)
			{
				first.data=data;
			}
		}
	}
}
