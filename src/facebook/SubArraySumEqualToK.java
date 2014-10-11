/**
 * 
 */
package facebook;

/**
 * @author Dinesh
 *
 */
public class SubArraySumEqualToK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={1,5,6,7,9,11};
		boolean res=new SubArraySumEqualToK().finKSum(arr, 21);
		System.out.println(res);
	}

	public boolean finKSum(int[] arr, int k)
	{
		int sum=0; 
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];

		}
		int rem=sum-k;
		int tempSum=sum;

		int m=0;
		int startIndex=0;
		while(m<arr.length)
		{
			if(tempSum>rem)
			{
				tempSum-=arr[m];
			}else
			{
				tempSum+=arr[startIndex++];
			}
			if(tempSum==rem)
				return true;

			m++;
		}
		return false;

	}

}