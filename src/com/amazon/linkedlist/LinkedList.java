/**
 * 
 */
package com.amazon.linkedlist;

/**
 * @author Dany
 *
 */
public class LinkedList {
	public int data;
	public LinkedList next;
	
	public LinkedList(int data)
	{
		
	}
	
	public LinkedList insertEnd(LinkedList head, int data)
	{
		LinkedList newNode=new LinkedList(data);
		if(head==null)
			return newNode;
		while(head.next!=null)
		{
			head=head.next;
		}
		head.next=newNode;
		return head;
	}
	
	public LinkedList insertFirst(LinkedList head, int data)
	{
		LinkedList newNode = new LinkedList(data);
		if(head==null)
			return newNode;
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	public LinkedList insertAfter(LinkedList head, int data, int afterData)
	{
		LinkedList newNode=new LinkedList(data);
		if(head==null) 
			return null;
		if(head.data==afterData)
		{
			newNode.next=head.next;
			head.next=newNode;
			return head;
		}
		
		while(head.next!=null)
		{
			if(head.data==afterData)
			{
				newNode.next=head.next;
				head.next=newNode;
				return head;
			}
			head=head.next;
			
		}
		return head;
			
	}
	
	public LinkedList delete(LinkedList head, int data)
	{
		if(head==null)
			return null;
		if(head.data==data)
			return head.next;
		while(head.next!=null)
		{
			if(head.data==data)
			{
				if(head.next==null)
				{
					return null;
				}else
				{
					head.data=head.next.data;
					head.next=head.next.next;
					return head;
				}
			}
				
			head=head.next;
		}
		return head;
				
	}
	
	public LinkedList lookUp()
	{
		
	}
}
