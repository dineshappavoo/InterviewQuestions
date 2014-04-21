package arraysandstring;


/**
 * @author Dany
 *
 */
public class ArrayMove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={9,4,3,7,6,5,1,2,8};
		int[] res=ArrayMove.arrayMove(arr, 3);
		for(int i:res)
		{
			System.out.print(" "+i);
		}

	}
	
	//To move first n elements to the end
	public static int[] arrayMove(int[] arr, int n)
	{
		int len=arr.length-n;
		
		arr=ArrayReverse.reverseArray(arr, 0, arr.length);
		arr=ArrayReverse.reverseArray(arr, 0, len);
		arr=ArrayReverse.reverseArray(arr, len, arr.length);
		
		return arr;

	}

}
