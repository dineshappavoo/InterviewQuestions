/**
 * 
 */
package nanosatisfi;

/**
 * @author Dany
 *
 */
public class Equillibrium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A={-7,1,5,2,-4,3,0};
		int sum=new Equillibrium().findEquii(A);
		System.out.println("sum : "+sum);
	}

	
	public int findEquii(int[] A)
	{
		int equiiElement=-1;
		 long  totSum=0;
		int N=A.length;
		for(int i=0;i<N;i++)
		{
			totSum+=A[i];
		}
		long sum=0,sumTill=0;
		for(int j=0;j<N;j++)
		{
			if(j==0||j==N-1)
			{
				if(totSum-A[j]==0)
					return j;
			}else
			{
				sumTill+=A[j-1];
				sum=totSum;
				sum-=(sumTill+A[j]);
				if(sum==sumTill)
					return j;
			}	
				
			
		}
		
		return equiiElement;
	}
}
