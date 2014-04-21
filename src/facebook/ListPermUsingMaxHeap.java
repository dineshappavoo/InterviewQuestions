/**
 * 
 */
package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dany
 *
 */
public class ListPermUsingMaxHeap {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		new ListPermUsingMaxHeap().generateInput("/users/dany/downloads/input000.txt"); 

	}
	
	public PriorityQueue<Integer> implementMaxHeapPriorityQueue()
	{
		 PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>()
		 {
			 public int compare(Integer o1, Integer	 o2)
			 {
				 int p1=o1;
				 int p2=o2;
				 return (p2-p1); 
				 }
			 }
		 );
		 return queue;
	}
	
	public void generateInput(String sFile) throws FileNotFoundException
	{
		File file=new File(sFile);
		Scanner scanner=new Scanner(file);
		int totalLists,k;
		ArrayList<ArrayList<Integer>> inList;
		ArrayList<Integer> list;
		int count=0;
		
		int inputSize=scanner.nextInt();
		for(int i=0;i<inputSize;i++)
		{
			inList=new ArrayList<ArrayList<Integer>>();
			totalLists=scanner.nextInt();
			k=scanner.nextInt();
			for(int j=0;j<totalLists;j++)
			{
				int listSize=scanner.nextInt();
				list=new ArrayList<Integer>();
				for(int m=0;m<listSize;m++)
				{
					list.add(scanner.nextInt());
					
				}
				inList.add(list);
			}
			count=findLargestfromLists(inList,k);
			System.out.println("Count :"+count);
			
		}
		//return inList;
		
	} 
	
	public int findLargestfromLists(ArrayList<ArrayList<Integer>> inList, int k)
	{
		PriorityQueue<Integer> maxHeap1=implementMaxHeapPriorityQueue();
		PriorityQueue<Integer> maxHeap2=implementMaxHeapPriorityQueue();
		Set<Integer> kthSortedList=new HashSet<Integer>();
		
		
		for(ArrayList<Integer> list : inList)
		{
			if(!list.isEmpty())
			{
				maxHeap1.add(list.get(0));
				list.remove(0);
			}
			
			
		}
		
		while(!maxHeap1.isEmpty())
		{
		for(ArrayList<Integer> list : inList)
		{
			if(!list.isEmpty())
			{
				maxHeap1.add(list.get(0));
				list.remove(0);
				//count++;
			}
			
			
		}
		maxHeap2.add(maxHeap1.poll());
		if(maxHeap2.size()>k)
		{
			kthSortedList.add(maxHeap2.poll());
			
		}
		}
		
		
		
		for(int n : kthSortedList)
		{
			System.out.println("Set : "+n);
		}
		return kthSortedList.size();
	}
	
	
	public boolean isAllListsEmpty(ArrayList<ArrayList<Integer>> inList)
	{
		boolean isAllListEmpty=true;
		for(ArrayList<Integer> list : inList)
		{
			if(!list.isEmpty())
				isAllListEmpty=false;
		}
		
		return isAllListEmpty;
		
	}
	

}
