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
		value value;
		Node next;
		
		public Node(key key, value value)
		{
			this.key=key;
			this.value=value;
			this.next=null;
		}
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
	
	public void put(key key, value value)
	{
		while(first!=null)
		{
			if(first.key==key)
			{
				first.value=value;
				return;
			}
			first=first.next;
		}
		first.next=new Node(key, value);
	}
	
	public value get(key key)
	{
		while(first!=null)
		{
			if(first.key==key)
			{
				return first.value;
			}
			first=first.next;
		}
		return null;
	}
	
	public value remove(key key)
	{
		while(first.next!=null)
		{
			if(first.next.key==key)
			{
				value value=first.next.value;
				first.next=first.next.next;
				return value;
			}
			first=first.next;
		}
		return null;
	}
	
	public boolean contains(key key)
	{
		while(first!=null)
		{
			if(first.key==key)
			{
				return true;
			}
			first=first.next;
		}
		return false;
	}
}
