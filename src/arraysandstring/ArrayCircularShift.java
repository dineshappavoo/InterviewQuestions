/**
 * 
 */
package arraysandstring;

/**
 * @author Dinesh Appavoo
 *
 */
public class ArrayCircularShift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int[] shiftArray(int[] arr, int n)
	{
		int len=arr.length,initial;
		int start=initial=arr[0];
		int d=0, temp;
		int[] out=new int[arr.length];
		while(start!=initial)
		{
			 d=(d+n)%len;
			 temp=arr[d];
		}
		return out;
	}

}
