/**
 * 
 */
package arraysandstring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dany
 *
 */
public class FBSolutionLinkedlist {



	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new FBSolutionLinkedlist().getInputData("/users/dany/downloads/input000.txt");

	}
	
	public void getInputData(String sFile) throws FileNotFoundException
	{
		File nFile=new File(sFile);
		Scanner scan=new Scanner(nFile);
		//ArrayList<ArrayList<Integer>> inAllList;
		LinkedList<LinkedList<Integer>> inAllList;
		LinkedList<Integer> playerList=new LinkedList<Integer>();
		
		LinkedList<LinkedList<Integer>> tempList=new LinkedList<LinkedList<Integer>>();
		
		
		LinkedList<Integer> tempBuffer=new LinkedList<Integer>();
		int k=0;
		int count=0;
		int playerListSize=0;
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			//To add an empty list
			inAllList=new LinkedList<LinkedList<Integer>>();
			inAllList.add(playerList);
			
			
			
			int noOfPlayers=scan.nextInt();
			k=scan.nextInt();
			System.out.println("k value "+k);
			for(int j=0;j<noOfPlayers;j++)
			{
				playerListSize=scan.nextInt();
				for(int m=0;m<playerListSize;m++)
				{
					
					/*
					for(ArrayList<Integer> test : inAllList)
					{
						System.out.println("list \n");
						for(int n1:test)
						{
							System.out.print(" "+n1);
						}
					}*/
					
					
					int value=scan.nextInt();
					//System.out.println("Value : "+value);
					//To append no to the existing list
					for(LinkedList<Integer> existingList : inAllList)
					{
						tempBuffer.addAll(existingList);
						tempBuffer.add(value);
						tempList.add(tempBuffer);
						tempBuffer=new LinkedList<Integer>();
						
					}
										
					
				}
				inAllList=new LinkedList<LinkedList<Integer>>();
				inAllList.addAll(tempList);

				tempList=new LinkedList<LinkedList<Integer>>();
				tempBuffer=new LinkedList<Integer>();
				
			}
			
			
			//To sort the array
			count=getCountFromAdmin(inAllList,k);
			System.out.println("Count Value : "+count);
			
		}
	}

	public int getCountFromAdmin(LinkedList<LinkedList<Integer>> inAllList, int k)
	{
		LinkedList<LinkedList<Integer>> selectionList=new LinkedList<LinkedList<Integer>>();
		Set<Integer> kNumberList=new HashSet<Integer>();
		LinkedList<Integer> tempList=new LinkedList<Integer>();
		
		System.out.println("Test");
		/*for(LinkedList<Integer> test : inAllList)
		{
			System.out.println("list ");
			for(int n:test)
			{
				System.out.print(" "+n);
			}
		}*/
		
		int kthValue=0;
		for(LinkedList<Integer> selectedList : inAllList)
		{
			Collections.sort(selectedList);
			kthValue=selectedList.get(k-1); 
			kNumberList.add(kthValue);
		}
		
		
		return kNumberList.size();
	}

}
