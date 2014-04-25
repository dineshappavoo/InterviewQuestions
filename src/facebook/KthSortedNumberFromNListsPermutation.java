/**
 * 
 */
package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/**
 * @author Dany
 *
 */
public class KthSortedNumberFromNListsPermutation {

	/**
	 * @param args
	 */
	//public static Set<Integer> resultSet=new HashSet<Integer>();
	public static ArrayList<Integer>[] inList=(ArrayList<Integer>[])new ArrayList[5];
	public static HashSet<Integer> resultSet=new HashSet<Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		/*ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(5);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(7);
		ArrayList<Integer> list3=new ArrayList<Integer>();
		list3.add(3);
		list3.add(6);
		
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(5);
		list1.add(3);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(8);
		list2.add(1);
		list2.add(6);
		
		ArrayList<Integer> list3=new ArrayList<Integer>();
		list3.add(7);
		list3.add(4);
		list3.add(9);

		
		inList[0]=list3;
		inList[1]=list2;
		inList[2]=list1;

		//inList[3]=list1;

		//ArrayList<Integer> permList=new ArrayList<Integer>();
		int[] permList=new int[3];

		//new KthSortedNumberFromNListsPermutation().addNumbersFromEachList(permList, 2, 3,0);
		
		System.out.println("size : "+resultSet.size());
		for(int i : resultSet)
		{
			System.out.print(" "+i);
		}*/
		
		new KthSortedNumberFromNListsPermutation().constructNLists("/users/dany/downloads/input000.txt"); 

		
	}
	public void constructNLists(String sFile) throws FileNotFoundException
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
			int[] permutList=new int[totalLists];
			//count=
			findkthLargestfromLists(inList, permutList, inList.size()-1, k, 0, totalLists);
			
			System.out.println("Count :"+resultSet.size());
			resultSet=new HashSet<Integer>();
			
		}
		//return inList;
		
	}
	
	
	public void findkthLargestfromLists(ArrayList<ArrayList<Integer>> inList, int[] permutList, int pos, int k, int level, int totalLists)
	{
		if(pos<0)
		{
			/*System.out.println("Test ");
			for(int i : permutList)
			{
				System.out.print(" "+i);
			}*/
			resultSet.add(findKthlargestFromList(permutList, k, totalLists));
			//resultSet.add(value);
			//permutList=new int[2];
			return;
		}
		ArrayList<Integer> intermediateList=inList.get(pos--);
		//while(intermediateList.isEmpty())
			//intermediateList=inList[pos--];
		for(int i : intermediateList)
			{
				permutList[level]=i;
				findkthLargestfromLists(inList, permutList, pos, k, level+1, totalLists);
			}
	}
	
	public int findKthlargestFromList(int[] inList, int k, int totalLists)
	{
		int[] permLst=new int[totalLists];
		System.arraycopy(inList, 0, permLst, 0, inList.length);
		Arrays.sort(permLst);
		return permLst[k-1];
	}

}
