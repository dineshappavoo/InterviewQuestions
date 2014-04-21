/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class ArrayReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={9,4,3,7,6,5,1,2,8};
		int[] res=ArrayReverse.reverseArray(arr, 0, 6);
		for(int i:res)
		{
			System.out.print(" "+i);
		}

	}
	
	public static int[] reverseArray(int[] arr, int start, int end)
	{
		int temp=0;
		
		for(int i=start,j=end-1;i<=j;i++,j--)
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}
		
		return arr;
	}

}
