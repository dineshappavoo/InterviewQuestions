/**
 * 
 */
package com.dynamicprogramming;

import java.util.HashMap;


/**
 * @author Dany
 *
 */
public class Fibanacci {

	/**
	 * @param args
	 */
	private static HashMap<Integer, Integer> memoTable=new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=new Fibanacci().fibonacci(8);
		System.out.println(res);

	}
	
	public int fibonacci(int n)
	{
		if(n<0)
			return -1;
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(memoTable.containsKey(n))
		{
			return memoTable.get(n);
		}else
		{
			memoTable.put(n, (fibonacci(n-1)+fibonacci(n-2)));
		}
		return memoTable.get(n);
	}
	
	

}
