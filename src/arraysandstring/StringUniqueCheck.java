/**
 * 
 */
package arraysandstring;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Dany
 *
 */
public class StringUniqueCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Dineshpvav";
		boolean res=new StringUniqueCheck().checkUnique2(str);
		System.out.println("String does not have duplicates : "+res);

	}
	public boolean checkUnique(String str)
	{
		if(str.length()>256)
			return false;
		Hashtable<Character, Boolean> hMap=new Hashtable<Character, Boolean>();
		for(int i=0;i<str.length();i++)
		{
			char c= str.charAt(i);
			if(hMap.containsKey(c))
				return false;
			else
				hMap.put(c, true);
		}
		return true;
		
	}
	
	public boolean checkUnique1(String str)
	{
		if(str.length()>256)
			return false;
		boolean[] bCheck = new boolean[256];
		for(int i=0;i<str.length();i++)
		{
			char c= str.charAt(i);
			if(bCheck[c])
				return false;
			else
				bCheck[c]=true;
		}
		return true;
		
	}
	
	public boolean checkUnique2(String str)
	{
		if(str.length()>256)
			return false;
		byte[] bCheck = new byte[256/8];
		for(int i=0;i<str.length();i++)
		{
			char c= str.charAt(i);
			if((bCheck[c/8] & (1<<(c%8)))!=0)
				return false;
			else
				bCheck[c/8]|=1<<(c%8);
		}
		return true;
		
	}

}
