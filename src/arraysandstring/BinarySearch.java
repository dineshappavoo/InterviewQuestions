/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={2,4,6,7,8,9,11,23};
		int res=new BinarySearch().doBinarySearch(arr, 12, 0, arr.length-1);
		if(res==-1)
			System.out.println("No not available");
		else
			System.out.println("No Available. Index is "+res);
	}
	
	public int doBinarySearch(int[] arr, int numToFind, int low, int high)
	{
		if(low<high)
		{
		int mid=(low+high)/2;
		if(arr[mid]==numToFind)
			return mid;
		else if(arr[mid]>numToFind)
			return doBinarySearch(arr, numToFind, low, mid);
		else if(arr[mid]<numToFind)
			return doBinarySearch(arr, numToFind, mid+1, high);
		}
		return -1;
			
	}

}
