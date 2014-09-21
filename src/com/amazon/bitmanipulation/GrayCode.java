/**
 * 
 */
package com.amazon.bitmanipulation;

/**
 * @author Dany
 *
 */
public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new GrayCode().isGrayCode((byte)2, (byte)4));
	}
	
	public boolean isGrayCode(byte a, byte b)
	{
		boolean isGray=false;
		if(NumberOfSetBits(a^b)==1)
			return true;
		else return false;
		
		/*if((countSetBits(a^b))==1)
			return true;
		else return false;*/
	}

	public int NumberOfSetBits(int i)
	{
	     i = i - ((i >> 1) & 0x55555555);
	     i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
	     return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
	}
	
	public int countSetBits(byte n)
	{
	  int count = 0;
	  while(n>0)
	  {
	    count += n & 1;
	    n >>= 1;
	  }
	  return count;
	}
}
