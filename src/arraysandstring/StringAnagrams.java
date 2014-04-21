/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class StringAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result=new StringAnagrams().isAnagram("DAny", "dany");
		System.out.println("Is Anagram : "+result);
	}
	
	public boolean isAnagram(String str1, String str2)
	{
		int[] strCountArr1=getCountASCII(str1);
		int[] strCountArr2=getCountASCII(str2);
		for(int i=0;i<256;i++)
		{
			if(strCountArr1[i]!=strCountArr2[i])
				return false;
		}
		
		return true;

		
	}
	
	public int[] getCountASCII(String str)
	{
		char c;
		int[] strCountArr=new int[256];
		for(int i=0;i<str.length();i++)
		{
			c=Character.toUpperCase(str.charAt(i)); // If both the cases are considered to be the same
			strCountArr[(int)c]++;
		}
		return strCountArr;
	}

}
