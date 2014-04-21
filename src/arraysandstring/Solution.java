package arraysandstring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	//public static ArrayList<ArrayList<Integer>> selectionList=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new Solution().getInputData("/users/dany/downloads/input000.txt");

	}
	
	public void getInputData(String sFile) throws FileNotFoundException
	{
		File nFile=new File(sFile);
		Scanner scan=new Scanner(nFile);
		ArrayList<ArrayList<Integer>> inAllList;
		ArrayList<Integer> playerList=new ArrayList<Integer>();
		
		ArrayList<ArrayList<Integer>> tempList=new ArrayList<ArrayList<Integer>>();
		
		
		ArrayList<Integer> tempBuffer=new ArrayList<Integer>();
		int k=0;
		int count=0;
		int playerListSize=0;
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			//To add an empty list
			inAllList=new ArrayList<ArrayList<Integer>>();
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
					for(ArrayList<Integer> existingList : inAllList)
					{
						tempBuffer.addAll(existingList);
						tempBuffer.add(value);
						tempList.add(tempBuffer);
						tempBuffer=new ArrayList<Integer>();
						
					}
										
					
				}
				inAllList=new ArrayList<ArrayList<Integer>>();
				inAllList.addAll(tempList);
				
				/*for(ArrayList<Integer> test : inAllList)
				{
					System.out.println("list \n");
					for(int n1:test)
					{
						System.out.print(" "+n1);
					}
				}*/
				
				tempList=new ArrayList<ArrayList<Integer>>();
				tempBuffer=new ArrayList<Integer>();
				
			}
			
			System.out.println("Test 2");
			//To sort the array
			count=getCountFromAdmin(inAllList,k);
			System.out.println("Count Value : "+count);
			
		}
	}

	public int getCountFromAdmin(ArrayList<ArrayList<Integer>> inAllList, int k)
	{
		ArrayList<ArrayList<Integer>> selectionList=new ArrayList<ArrayList<Integer>>();
		Set<Integer> kNumberList=new HashSet<Integer>();
		ArrayList<Integer> tempList=new ArrayList<Integer>();
		
		System.out.println("Test");
		for(ArrayList<Integer> test : inAllList)
		{
			System.out.println("list ");
			for(int n:test)
			{
				System.out.print(" "+n);
			}
		}
		
		int kthValue=0;
		for(ArrayList<Integer> selectedList : inAllList)
		{
			Collections.sort(selectedList);
			kthValue=selectedList.get(k-1); 
			kNumberList.add(kthValue);
		}
		
		
		return kNumberList.size();
	}
}
