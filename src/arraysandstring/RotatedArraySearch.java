/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class RotatedArraySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={4,5,6,7,8,1,2,3};
		int res=new RotatedArraySearch().findMin(arr, 0, 7);
		System.out.println(res);

	}
	
	public int findMin(int[] arr, int low, int high)
	{
		//if(low<high)
		//{
			int mid=(low+high)/2;
			if((arr[mid]>arr[low])&&(arr[mid]>arr[high]))
			{
				return findMin(arr, mid+1, high);
			}else if((arr[mid]<arr[low])&&(arr[mid]<arr[high]))
			{
				if((arr[mid]<arr[mid-1])&&(arr[mid]<arr[mid+1]))
				{
					return arr[mid];

					
				}else
				return findMin(arr, low, mid-1);
			}else //if((arr[mid]<arr[mid-1])&&(arr[mid]<arr[mid+1]))
			{
				return arr[mid];
			
			}

		//}
			//return -1;
	}

}
