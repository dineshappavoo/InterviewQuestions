/**
 * 
 */
package com.dynamicprogramming;

import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class CoinDenomination {

	/**
	 * @param args
	 */
	static HashMap<Integer, Integer> memoTable=new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime=System.currentTimeMillis();

		//int res=new CoinDenomination().findNways(255, new int[]{5,4,3});
		//System.out.println(res);
		//int res1=new CoinDenomination().findDenoms(10, 10, new int[]{5,4,3},0, new HashMap<Integer, String>());
		//System.out.println(res1);
		
		long midTime=System.currentTimeMillis();
		System.out.println("Normal execution "+(midTime-startTime));
		
		
		int res1=new CoinDenomination().findNWaysDP(210, new int[]{5,4,3});
		System.out.println(res1);
		
		long endTime=System.currentTimeMillis();
		System.out.println("DP execution "+(endTime-midTime));
	}
	
	public int findNways(int value, int[] denom)
	{
		if(value==0)
			return 1;
		if(value<0)
			return 0;
		int i=0;
		for(int d : denom)
		{
			i+=findNways(value-d, denom);
		}
		return i;
	}
	
	public int findNWaysDP(int value, int[] denom)
	{
		if(value==0)
			return 1;
		if(value<0)
			return 0;
		if(memoTable.containsKey(value))
		{
			return memoTable.get(value);
		}
		int i=0;
		for(int d:denom)
		{
			int m=findNWaysDP(value-d, denom);
			memoTable.put(value-d, m);
			i+=m;
		}
		return i;
	}
	
	public int findDenoms(int value,int origValue, int[] denom, int level, HashMap<Integer, String> denominations)
	{
		if(value==0)
		{
			denominations.put(level, origValue-value+",");
			printPath(denominations,level);
			return 1;
		}
		if(value<0)
		{
			return 0;
		}
		int i=0;
		denominations.put(level, origValue-value+",");

		for(int d : denom)
		{
			i+=findDenoms(value-d, value, denom,level+1, denominations);
		}
		return i;
		
	}
	
	public void printPath(HashMap<Integer, String> ways, int level)
	{
		for(int i=0;i<=level;i++)
		{
			System.out.print(ways.get(i));
		}
		System.out.println();
	}

}
