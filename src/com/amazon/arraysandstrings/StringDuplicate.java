/**
 * 
 */
package com.amazon.arraysandstrings;

import java.util.HashMap;

/**
 * @author Dinesh Appavoo
 *
 */
public class StringDuplicate {

	public static void main(String[] args) {

	}
	
	public boolean isDuplicateExist(String str)
	{
		if(str.length()>256)
			return false;
		HashMap<Character, Boolean> hMap=new HashMap<Character, Boolean>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(hMap.get(c))
				return false;
			else
				hMap.put(c, true);
		}
		return true;
	}

}
