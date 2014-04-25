/**
 * 
 */
package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Dany
 *
 */
public class KthSortedListInNListsDP {

	/**
	 * @param args
	 */
	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> hMap=new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			resultSet.add(findKthlargestFromList(permutList, k, totalLists));
			
			return;
		}
		ArrayList<Integer> intermediateList=inList.get(pos--);
		
		for(int i : intermediateList)
			{
			if(pos==0)
			{
				ArrayList<Integer> memoList=new ArrayList<Integer>();
				ArrayList<ArrayList<Integer>> memoNumberList=new ArrayList<ArrayList<Integer>>();
				memoList.add(i);
				memoNumberList.add(memoList);
				hMap.put(i,memoNumberList);
			}
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
	public ArrayList<Integer> returnPermutations(ArrayList<ArrayList<Integer>> inList)
	{
		
	}

}
