/**
 * 
 */
package arraysandstring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;



/**
 * @author Dany
 *
 */
public class AmazonChallenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	
	
	public class Product
	{
		String productId;
		int priority;
		
		public Product(String productId, int priority)
		{
			this.productId=productId;
			this.priority=priority;
		}
		
	}
	
	public PriorityQueue<Product> implementMaxHeapPriorityQueue()
	{
		 PriorityQueue<Product> queue = new PriorityQueue<Product>(11, new Comparator<Product>()
		 {
			 public int compare(Product o1, Product o2)
			 {
				 int p1=o1.priority;
				 int p2=o2.priority;
				 return (p2-p1); 
				 }
			 }
		 );
		 return queue;
	}
	
	public ArrayList<String> getFriendsListForUser(String nUserId)
	{
		ArrayList<String> friendsList=new ArrayList<String>();
		return friendsList;
		
	}
	
	public ArrayList<String> getPurchasesForUser(String nUserId)
	{
		ArrayList<String> productList=new ArrayList<String>();
		return productList;
	}
	
	public ArrayList<String> findpriorityProduct(String nUserId)
	{
		ArrayList<String> friendsList=getFriendsListForUser(nUserId);
		ArrayList<String> productList=null;
		ArrayList<String> priorityProductList=new ArrayList<String>();
		
		ArrayList<String> ownProductList=getPurchasesForUser(nUserId);
		HashMap<String, Integer> priorityMap=new HashMap<String, Integer>();
		
		for(String user:friendsList)
		{
			productList=getPurchasesForUser(user);
			for(String product:productList)
			{
				if(!ownProductList.contains(product))
				{
				if(priorityMap.containsKey(product))
				{
					
					priorityMap.put(product, priorityMap.get(product)+1);
				}else
				{
					priorityMap.put(product, 1);
				}
				}
			}
		}
		
		PriorityQueue<Product> queue=implementMaxHeapPriorityQueue();
		
		for(String product:priorityMap.keySet())
		{
			queue.add(new Product(product, priorityMap.get(product)));
		}
		


		while(!queue.isEmpty())
		{
			priorityProductList.add(queue.poll().productId);
		}
		
		return priorityProductList;
	}


}
