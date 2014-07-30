/**
 * 
 */
package arraysandstring;

/**
 * @author Dinesh Appavoo
 *
 */
public class ArrayMaxProduct {

	/**
	 * @param args
	 */
	/*
	 * ALGORITHM
	 * for i=1 to n
	 *   find products of i to i+l array elements
	 *   if product>maxproduct
	 *      maxProduct=product and maxStartIndex=i
	 *  return maxStartIndex
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,1,-7,-8,9,16,-4,12};
		int res=ArrayMaxProduct.findmaxProductSubArray(arr, 3);
		System.out.println(res);
		for(int i=0;i<3;i++)
		{
		System.out.print(arr[res++]);
		}

	}
	
	public static int findmaxProductSubArray(int[] arr, int l)
	{
		int len=arr.length;
		int maxProduct=Integer.MIN_VALUE;
		int maxStartIndex=0,tempProduct=1;
		for(int i=0;i<=len-l;i++)
		{
			for(int j=i;j<((i+l));j++)
			{
				tempProduct*=arr[j];
			}
			if(tempProduct>maxProduct)
			{
				maxProduct=tempProduct;
				maxStartIndex=i;
			}
			tempProduct=1;
		}
		return maxStartIndex;
	}

}
