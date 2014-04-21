/**
 * 
 */
package arraysandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dany
 *
 */
public class MaxSubArrayWithNegative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={3,4,-10,7,-8,9,-7,5,4};
		HashMap<Integer,WrapMaxSum> result=new MaxSubArrayWithNegative().findMaxSum(arr);
		for(int key : result.keySet())	
		{
			WrapMaxSum sumBean=result.get(key);
			System.out.println("Max Sum : "+sumBean.max+" Start Index : "+sumBean.i+"  End Index : "+sumBean.j);
		}
	}
	
	public class WrapMaxSum
	{
		int max;
		int i;
		int j;
	}
	
	public HashMap<Integer,WrapMaxSum> findMaxSum(int[] arr)
	{
		int maxStart=0;
		int maxEnd=0;
		int tempStart=0;
		int tempEnd=0;
		int maxSum=Integer.MIN_VALUE;
		int tempSum=0;
		HashMap<Integer,WrapMaxSum> maxArr=new HashMap<Integer,WrapMaxSum>();
		//ArrayList<WrapMaxSum> maxArr=new ArrayList<WrapMaxSum>();
		for(int i=0;i<arr.length;i++)
		{
			tempSum+=arr[i];
			tempEnd=i;
			if(tempSum>maxSum)
			{
				maxSum=tempSum;
				tempEnd=i;
				maxEnd=tempEnd;
				maxStart=tempStart;
			}
			if(tempSum<0)
			{
				tempStart=i+1;
				tempEnd=tempStart;
				tempSum=0;
				WrapMaxSum maxBean=new WrapMaxSum();
				maxBean.i=maxStart;
				maxBean.j=maxEnd;
				maxBean.max=maxSum;
				maxArr.put(maxBean.max, maxBean);
				
			}
			
		}
		WrapMaxSum maxBean=new WrapMaxSum();
		maxBean.i=maxStart;
		maxBean.j=maxEnd;
		maxBean.max=maxSum;
		maxArr.put(maxBean.max, maxBean);
		
		return maxArr;
		
	}

}
