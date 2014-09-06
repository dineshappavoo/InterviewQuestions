/**
 * 
 */
package com.amazon.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;



/**
 * @author Dinesh Appavoo
 *
 *
 *Suppose you are an engineer on the Amazon Media team. Your team needs to launch a new recommendation feature called “Stuff Your Friends are Buying”.  The recommendation logic is based on the following rules:
•	A customer should only be recommended product that their friends bought but they haven’t bought.
•	The recommendations priority is driven by how many friends have purchased the same item – if multiple friends purchased the same item, it should be higher in the recommendations than a product that only one friend owns.

You are provided two library functions to help you
•	getFriendsListForUser – returns a list of customer IDs (strings that uniquely identify an Amazon user) representing the friends of an Amazon user
•	getPurchasesForUser – returns a list of product IDs (strings that uniquely identify an item in the Amazon catalog) for an Amazon user ordered by purchase time with newest purchase first in list and oldest purchase last in list
 
For this evaluation, please:
1)	Write a function that provides a ranked (high to low) list of recommendations (product IDs) for a provided user. You may use any IDE and framework that you are comfortable with.
2)	Write code for a few key unit tests for your code.
3)	Enumerate other unit test scenarios (code not required).
4)	Provide the space and time complexity of your solution.
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
