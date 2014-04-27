package dynamicprogramming;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Dany
 *
 */
public class CuttingRod {

	/**
	 * @param args
	 */
	
	public static ArrayList<Integer> result= new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] length={1,2,3,4,5,6,7,8};
		int[] price={0,1,5,8,9,10,17,17,20};//0th element is ZERO because weight we are considering from 1 to 8 not zero to seven
		
		int res=new CuttingRod().calMaxProfit(price, price.length);
		System.out.println("Result : "+res);

	}
	
	/**
	 * Function to get maximum profit from the input
	 * @param price
	 * @param n
	 * @return
	 */
	public int calMaxProfit(int[] price, int n)
	{
		ArrayList<Integer> result= new ArrayList<Integer>();
		int currentProfit=0;
		
		for(int i=1;i<n;i++)
		{
		
			int maxProfit=price[i] + calMaxProfit(price, n-i);
			if(maxProfit>currentProfit)
				currentProfit=maxProfit;
		}
		
		
		return currentProfit;
	}

}
