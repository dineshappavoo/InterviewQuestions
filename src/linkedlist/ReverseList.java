/**
 * 
 */
package linkedlist;

/**
 * @author Dinesh Appavoo
 *
 */
public class ReverseList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static LinkedList reverseList(LinkedList head)
	{
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		
		LinkedList secondNode=head.next;
		
		head.next=null;
		
		
		LinkedList reverseList=reverseList(secondNode);
		
		secondNode.next=head;
		
		return reverseList;
		

	}

}
