/**
 * 
 */
package arraysandstring;

import java.math.BigInteger;

/**
 * @author Dany
 *
 */
public class MaxIntegerMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new MaxIntegerMultiplication().multiplyMaxInt();
		
	}
	
	public BigInteger multiplyMaxInt()
	{
		int d=4567;
		BigInteger a=new BigInteger("2147483647");
		BigInteger b=new BigInteger("2147483647");
		System.out.println("a : "+a);
		System.out.println("b : "+b);

		BigInteger c=a.multiply(b);
		c=c.add(BigInteger.valueOf(d));
		System.out.println("c : "+(c));
		

		return c;
	}

}
