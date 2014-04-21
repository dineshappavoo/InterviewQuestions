/**
 * 
 */
package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


/**
 * @author Dinesh
 *
 *
 * Description : 
 *	N friends are playing a game. Each of them has a list of numbers in front of himself.
	Each of N friends chooses a number from his list and reports it to the game administrator. 
	Then the game administrator sorts the reported numbers and shouts the K-th largest number.
	You want to know the count all possible numbers that the game administrator can shout.
 */
public class ListPermutation {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> inList=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(5);
		list1.add(3);
		inList.add(list1);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(8);
		list2.add(1);
		list2.add(6);
		inList.add(list2);

		ArrayList<Integer> list3=new ArrayList<Integer>();
		list3.add(7);
		list3.add(4);
		list3.add(9);
		inList.add(list3);

		
		new ListPermutation().generateInput("/users/dany/downloads/input000.txt");
		//int count = new ListPermutation().findLargestfromLists(in);
		//System.out.println("\n\nTotal count "+count);
		
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
			count=findLargestfromLists(inList);
			System.out.println("Count :"+count);
			
		}
		//return inList;
		
	}
	
	
	public int findLargestfromLists(ArrayList<ArrayList<Integer>> inList)
	{
		Set<Integer> largestCount=new HashSet<Integer>();
		while(!isAnyListEmpty(inList))
		{
			
			//System.out.println("Test case \n \n");
		for(ArrayList<Integer> list : inList)
		{
			Collections.sort(list);
			Collections.reverse(list);
		}
		
		
			Collections.sort(inList, new Comparator<ArrayList<Integer>>() {

				@Override
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					// TODO Auto-generated method stub
					 Integer val1, val2;
				        val1 =o1.get(0);
				        val2 =o2.get(0);
				        return (val2.compareTo(val1));
				}
			
			});;

			largestCount.add(inList.get(0).get(0));
			inList.get(0).remove(0);

			//print2DArrayList(inList);
			
			
		}
		return largestCount.size();
		
		
		
	}
	
	public boolean isAnyListEmpty(ArrayList<ArrayList<Integer>> inList)
	{
		boolean isListEmpty=false;
		for(ArrayList<Integer> list : inList)
		{
			if(list.isEmpty())
				isListEmpty=true;
		}
		
		return isListEmpty;
	}
	
	public void print2DArrayList(ArrayList<ArrayList<Integer>> inList)
	{

		for(ArrayList<Integer> list : inList)
		{
			System.out.println("");
			for(int n : list)
			{
				System.out.print(" "+n);
			}
		}
	}

}
