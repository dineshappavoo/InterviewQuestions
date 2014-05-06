/**
 * 
 */
package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dinesh Appavoo
 *
 *Description:
 *
 *N friends are playing a game. Each of them has a list of numbers in front of himself.
 *Each of N friends chooses a number from his list and reports it to the game administrator. 
 *Then the game administrator sorts the reported numbers and shouts the K-th largest number.
 *You want to know the count all possible numbers that the game administrator can shout.
 *
 *
 *
 */
public class KthSortedNumberFromNListEfficient {

	public static Set<Integer> resultSet=new HashSet<Integer>();
	public static int[] min=null;
	public static int[] max=null;

	
	public static void main(String[] args) throws FileNotFoundException {

		new KthSortedNumberFromNListEfficient().constructNLists("/users/dany/downloads/input000.txt"); 

	}
	
	public void constructNLists(String sFile) throws FileNotFoundException
	{
		File file=new File(sFile);
		Scanner scanner=new Scanner(file);
		int totalLists,k, nValue;
		ArrayList<Integer> intermediateList=null;
		ArrayList<ArrayList<Integer>> inList=null;

		
		int inputSize=scanner.nextInt();
		for(int i=0;i<inputSize;i++)
		{
			totalLists=scanner.nextInt();
			k=scanner.nextInt();
			min=new int[totalLists];
			max=new int[totalLists];
			Arrays.fill(min, Integer.MAX_VALUE);
			Arrays.fill(max, Integer.MIN_VALUE);
			
			inList=new ArrayList<ArrayList<Integer>>();
			
			for(int j=0;j<totalLists;j++)
			{
				int listSize=scanner.nextInt();
				intermediateList=new ArrayList<Integer>();
				for(int m=0;m<listSize;m++)
				{
					nValue=scanner.nextInt();
					if(nValue<min[j])
						min[j]=nValue;
					if(nValue>max[j])
						max[j]=nValue;
					intermediateList.add(nValue);
				}
				inList.add(intermediateList);
			}
			
			processInput(inList, k);
			System.out.println(resultSet.size());

			resultSet=new HashSet<Integer>();
		}
	}

	public void processInput(ArrayList<ArrayList<Integer>> inList, int k)
	{
		int lCount=0, gCount=0;
		int N=inList.size();
		ArrayList<Integer> interList=null;
		int nValue=0;
		int minArrValue,maxArrValue;

		for(int i=0;i<N;i++)
		{
			interList=new ArrayList<Integer>();
			interList=inList.get(i);
			for(int j=0;j<interList.size();j++)
			{
				nValue=interList.get(j);
				lCount=0;
				gCount=0;
				for(int p=0;p<min.length;p++) //To iterate through min array
				{
					if(p!=i)
					{
					minArrValue=min[p];
					if(nValue<minArrValue)
						lCount++; //If the chosen element is less than the minimum element in the list
					}
				}
				
				for(int q=0;q<max.length;q++) //To iterate through max array
				{
					if(q!=i)
					{
					maxArrValue=max[q];
					if(nValue>maxArrValue)
						gCount++; //If the chosen element is greater than the maximum element in the list
					}
				}
				
				
				if(gCount<=k-1&&lCount<=(N-k))  //The problem are lists where there are only numbers above or only numbers below. The first ones must be at most N-K, the second ones must be at most K. If this is not true, your number cannot be picked.
				{
					resultSet.add(nValue);
				}
			}
		}
	}
}
