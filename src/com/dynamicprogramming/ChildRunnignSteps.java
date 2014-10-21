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

		int res = new ChildRunnignSteps().findSteps(4);
		//System.out.println(count);
		System.out.println(res);

	}
	
	public int findSteps(int n)
	{
		if(n==0)
			return 0;
		else
			return fStepsUsingDP(n);
			
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
	
	public void fSteps(int n)
	{
		if(n<0)
			return;
		
		if(n==0)
		{
			count++;
			return;
		}

		fStepsUsingDP(n-1);
		fStepsUsingDP(n-2);
		fStepsUsingDP(n-3);
	}

}
