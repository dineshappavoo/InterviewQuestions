/**
 * 
 */
package codility.demoTJDANR4NU;

/**
 * @author Dany
 *
 */
public class Solution {

	/**
	 * @param args
	 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
		Your goal is to find that missing element.
		Write a function:
		class Solution { public int solution(int[] A); }
		that, given a zero-indexed array A, returns the value of the missing element.
		For example, given array A such that:
		  A[0] = 2
		  A[1] = 3
		  A[2] = 1
		  A[3] = 5
		the function should return 4, as it is the missing element.
		Assume that:
		N is an integer within the range [0..100,000];
		the elements of A are all distinct;
		each element of array A is an integer within the range [1..(N + 1)].
		Complexity:
		expected worst-case time complexity is O(N);
		expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
		Elements of input arrays can be modified.
	 */
	public static void main(String[] args) {
		//int [] A={1,5,3,4,2,7};
		int[] A={4,3,2,5,6};
		System.out.println(new Solution().solution(A));
	}

	
	public int solution(int[] A) {
        long sum=0, value=0;
        int length=A.length;
       /* if(length==0)
        	return 1;
        if(length==1)
        {
        	return 1;
        }*/
        for(int i=0;i<length;i++)
        {
        	if(!(A[i]==(length+1)))
        	sum+=A[i];
        }
        value=((length*(length+1))/2);
        return (int) (value-sum);
        
    }
}
