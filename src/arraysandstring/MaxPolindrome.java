/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class MaxPolindrome {

	/**
	 * @param args
	 */
	
	/*
	 * 
	 * MAX_POLINDROME(str)
	 * for i 1 to length
	 *  if current and current-1 matches //even length
	 *   move both sides,count and check with max
	 *  else if current and current-2 maches //odd length
	 *   move both sides,count and check with max
	 * 
	 * return the max length string
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str="ABCBAHELLOHOWRACECARAREYOUIAMAIDOINGGOOD";
		String res=MaxPolindrome.findmaxPolindrome(str);
		System.out.println(res);
	}

	
	public static String findmaxPolindrome(String str)
	{
		int len=str.length();
		if(len<2)
			return str;
		
		int wordLength=0, maxWordLength=0;
		char current;
		int maxStart=0,maxEnd=0;
		String res="";
		int k,l;
		for(int i=2;i<len;i++)
		{
			current=str.charAt(i);
			if(current==str.charAt(i-1)) //even length
			{
				k=i-1;
				l=i;
				while(str.charAt(k)==str.charAt(l) && l!=len-1 && k>0)
				{
					l++;
					k--;
				}
				
				wordLength=l-k;
				if(wordLength>maxWordLength)
				{
					maxWordLength=wordLength;
					maxStart=k+1;
					maxEnd=l-1;
							
				}
				
			}else if(current==str.charAt(i-2)) //odd length
			{
				k=i-2;
				l=i;
				while(str.charAt(k)==str.charAt(l) && l!=len-1 && k>0)
				{
					l++;
					k--;
				}
				
				wordLength=l-k;
				if(wordLength>maxWordLength)
				{
					maxWordLength=wordLength;
					maxStart=k+1;
					maxEnd=l-1;
							
				}
				
			}
		}
		
		for(int m=maxStart;m<=maxEnd;m++)
		{
			res+=str.charAt(m);
		}
		
		return res;
	}
}
