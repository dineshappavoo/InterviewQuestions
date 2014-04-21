/**
 * 
 */
package arraysandstring;

/**
 * @author Dany
 *Operator overloading is not possible in java just a try
 */
public class Oper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	String value="";
	
	public Oper(String value)
	{
		this.value=value;
	}
	
	public static String operator <<(Oper lh, int rh)
	{
		int len=lh.value.length()-rh;
		return lh.value.substring(len)+lh.value.substring(0, len);
		
	}
}
