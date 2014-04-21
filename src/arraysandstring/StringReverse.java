/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String stringReverse(String str)
	{
		StringBuffer sBuffer=new StringBuffer();
		int len=str.length();
		for(int i=len-1;i>=0;i--)
		{
			sBuffer.append(str.charAt(i));
		}
		return sBuffer.toString();
	}
	
	public String stringReverse1(String str)
	{
		String newStr="";
		return newStr;
	}

}
