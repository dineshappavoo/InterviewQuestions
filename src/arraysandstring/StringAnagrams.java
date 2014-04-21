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

		boolean result=new StringAnagrams().isAnagram("fAny", "dany");
		System.out.println("Is Anagram : "+result);
	}
	
	public boolean isAnagram(String str1, String str2)
	{
		//To get the no of occurrences of each character and store it in their ASCII location
		int[] strCountArr1=getASCIICountArr(str1);
		int[] strCountArr2=getASCIICountArr(str2);
		
		//To Test whether the two arrays have the same count of characters. Array size 256 since ASCII 256 unique values
		for(int i=0;i<256;i++)
		{
			if(strCountArr1[i]!=strCountArr2[i])
				return false;
		}
		return true;
	}
	
	public int[] getASCIICountArr(String str)
	{
		char c;
		//Array size 256 for ASCII
		int[] strCountArr=new int[256];
		for(int i=0;i<str.length();i++)
		{
			c=str.charAt(i); 
			c=Character.toUpperCase(c);// If both the cases are considered to be the same
			strCountArr[(int)c]++; //To increment the count in the character's ASCII location
		}
		return strCountArr;
	}

}
