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
		return new ListIterator(first);
	}
	
	public int getSize()
	{
		return N;
	}
	
	public void put(key key, value value)
	{
		Node x=first;
		while(x!=null)
		{
			if(x.key.equals(key))
			{
				x.value=value;
				return;
			}
			x=x.next;
		}
		first=new Node(key, value);
	}
	
	public value get(key key)
	{
		Node x=first;
		while(x!=null)
		{
			if(x.key.equals(key))
			{
				return x.value;
			}
			x=x.next;
		}
		return null;
	}
	
	public value remove(key key)
	{
		Node x=first;

		while(x.next!=null)
		{
			if(x.next.key.equals(key))
			{
				value value=x.next.value;
				x.next=x.next.next;
				return value;
			}
			x=x.next;
		}
		return null;
	}
	
	public boolean contains(key key)
	{
		Node x=first;

		while(x!=null)
		{
			if(x.key.equals(key))
			{
				return true;
			}
			x=x.next;
		}
		return false;
	}
	
	public void iterateList()
	{
		Node x=first;

		while(x!=null)
		{
			System.out.println("Key : "+first.key+" Value : "+first.value);
			x=x.next;
		}
	}
}
