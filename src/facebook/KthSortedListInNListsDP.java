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
	public static HashSet<Integer> resultSet=new HashSet<Integer>();

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
			findPermutations(inList, inList.size()-1, k, 0);
			
			System.out.println("Count :"+resultSet.size());
			resultSet=new HashSet<Integer>();
			
		}
		//return inList;
		
	}
	
	

	
	public int findKthlargestFromList(int[] inList, int k, int totalLists)
	{
		int[] permLst=new int[totalLists];
		System.arraycopy(inList, 0, permLst, 0, inList.length);
		Arrays.sort(permLst);
		return permLst[k-1];
	}
	public void findPermutations(ArrayList<ArrayList<Integer>> inList,int pos, int k, int current)
	{
		ArrayList<Integer> intermediateList=inList.get(pos--);
		for(int i : intermediateList)
			{
			current=i;
			if(pos==0)
			{
				ArrayList<Integer> memoList=new ArrayList<Integer>();
				ArrayList<ArrayList<Integer>> memoNumberList=new ArrayList<ArrayList<Integer>>();
				memoList.add(i);
				memoNumberList.add(memoList);
				hMap.put(i,memoNumberList);
				return;
			}
			else
			{
				if(hMap.containsKey(current))
				{
				ArrayList<ArrayList<Integer>> interList=hMap.get(current);
				for(ArrayList<Integer> list : interList)
				{
					list.add(i);
				}
				//hMap.put(current, interList);
				}
				else
				{
					ArrayList<ArrayList<Integer>> interList=null;
				}
			}
				//permutList[level]=i;
			findPermutations(inList, pos, k, current);
			}
		
	}

}
