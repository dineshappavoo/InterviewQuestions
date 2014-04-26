/**
 * 
 */
package trees;

import java.util.ArrayList;

/**
 * @author Dany
 *
 */
public class TreeList {

	public int data;
	public ArrayList<TreeList> adjacent;
	public boolean visited;
	
	public TreeList(int data)
	{
		this.data=data;
		adjacent=new ArrayList<TreeList>();
		
	}
	
}
