/**
 * 
 */
package linkedlist;

/**
 * @author Dany
 *
 */
public class LinkedList {

	public int data;
	public LinkedList next;
	
	public LinkedList(int data)
	{
		this.data=data;
	}
	
	public void addLast(int data)
	{
		LinkedList head=this;
		LinkedList node=new LinkedList(data);
		
		while(head.next!=null)
		{
			head=head.next;
		}
		head.next=node;
	}
	
	public void traverseList()
	{
		LinkedList head=this;
		System.out.println("Node : "+head.data);
		while(head.next!=null)
		{
			head=head.next;
			System.out.println("Node : "+head.data);

		}
	}
	
	public void addFirst(int data)
	{
		LinkedList node=new LinkedList(data);
		LinkedList head=this;
		node.next=head;
		head=null;
		head=node;
	}
}
