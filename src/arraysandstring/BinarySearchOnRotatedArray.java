/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class BinarySearchOnRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={3,4,6,7,8,9,1,2};
		int res=new BinarySearchOnRotatedArray().findMin(arr, 0, arr.length-1);
		if(res==-1)
			System.out.println("No not available");
		else
			System.out.println("No Available. No is "+res);
	}
	
	public int findMin(int[] arr, int low, int high)
	{
		if(low<high) 
		{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		int mid=(low+high)/2;
		if((arr[mid]>=arr[low])&&(arr[mid]<arr[high]))
			return arr[low];
		else if(arr[mid]>arr[high])
			return findMin(arr, mid+1, high);
		else if(arr[mid]<arr[high])
			return findMin(arr, low, mid);
		}
		return -1;
	}

}
