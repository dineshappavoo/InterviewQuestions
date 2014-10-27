/**
 * 
 */
package com.amazon.bitmanipulation;

/**
 * @author Dany
 *
 */
public class BitComaprison {

	/**
	 * @param args
	 */
	
	//Class to implement a?b:c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int res = new BitComaprison().findAquestionBcolonCsemicolon(5, 9, 4);
		System.out.println(res);
	}
	
	public int findAquestionBcolonCsemicolon(int a, int b, int c)
	{
		int res=0;
		int[] buff={b,c};
		System.out.println(a==0);
		
		res=buff[(a&1)&(1)];
		return res;
		
	}
	
	

}
