/**
 * 
 */
package com.dynamicprogramming;

import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class ChildRunnignSteps {

	/**
	 * @param args
	 */

	static int count=0;
	static HashMap<Integer, Integer> memoTable=new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ChildRunnignSteps().findSteps(20);
		System.out.println(count);
		//System.out.println(res);

	}

	public void findSteps(int n)
	{
		if(n==0)
			return;
		else
			fSteps(n,n,0,new HashMap<Integer, String>());

	}
	public int fStepsUsingDP(int n)
	{
		if(n<0)
			return 0;

		if(n==0)
		{
			count++;
			return 1;
		}
		if(memoTable.containsKey(n))
		{
			return memoTable.get(n);
		}else
		{
			memoTable.put(n, fStepsUsingDP(n-1) + fStepsUsingDP(n-2) + fStepsUsingDP(n-3));
		}
		return memoTable.get(n);
	}

	public void fSteps(int n, int origN, int level, HashMap<Integer, String> ways)
	{
		if(n<0)
			return;

		if(n==0)
		{
			ways.put(level, (origN-n)+"");
			count++;
			printWays(ways, level);
			return;
		}

		ways.put(level, ""+(origN-n));
		fSteps(n-1, n, level+1, ways);
		fSteps(n-2, n, level+1, ways);
		fSteps(n-3, n, level+1, ways);
	}

	public void printWays(HashMap<Integer, String> ways, int level)
	{
		for(int i=0;i<=level;i++)
		{
			System.out.print(ways.get(i)+",");
		}
		System.out.println();
	}

}
