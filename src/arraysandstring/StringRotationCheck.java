/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class StringRotationCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new StringRotationCheck().isRotation("ABCDABD", "BABDABC"));
	}
	
	public boolean isRotation(String a, String b)
	{
		int n=a.length();
		int m=b.length();
		int pos=0, i=0,j=0;
		while(pos<m&&i<n)
		{
			if(a.charAt(i)==b.charAt(j))
			{
				i++;
				j=(j+1)%m;
				
			}else
			{
				i=0;
				j=pos+1;
				pos++;
			}
		}
		
		if(i==n)
		{
			return true;
		}else
			return false;
	}

}
