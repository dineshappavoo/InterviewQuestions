/**
 * 
 */
package linkedlist;

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
		LinkedList head=new LinkedList(5);
		head.addLast(10);
		head.addLast(15);
		//head.traverseList();
		//head.addFirst(23);
		//head.addFirst(45);
		head.traverseList();
		System.out.println("2");
		head=ReverseList.reverseList(head);
		head.traverseList();
	}

}
