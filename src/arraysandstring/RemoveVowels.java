/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *
 */
public class RemoveVowels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new RemoveVowels().removeVowel("adineshAppa"));
	}
	
	public String removeVowels(String str)
	{
		boolean[] bArr=new boolean[256];
		StringBuffer sBuffer=new StringBuffer();
		bArr[(int)'a']=true;
		bArr[(int)'e']=true;
		bArr[(int)'i']=true;
		bArr[(int)'o']=true;	
		bArr[(int)'u']=true;

		bArr[(int)'A']=true;
		bArr[(int)'E']=true;
		bArr[(int)'I']=true;
		bArr[(int)'O']=true;
		bArr[(int)'U']=true;
		
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(!bArr[c])
			{
				sBuffer.append(c);
			}
		}
		return sBuffer.toString();
	}
	
	public String removeVowel(String str)
	{
		StringBuffer sBuffer=new StringBuffer();
			
		str=str.replaceAll("[aeiouAEIOU](\\B)", "");
		
		return str;
	}

}
