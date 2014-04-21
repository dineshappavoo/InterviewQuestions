/**
 * 
 */
package arraysandstring;

import java.util.ArrayList;

/**
 * @author Dany
 *
 */

public class ArrayDiffEqualsK {

	/**
	 * @param args
	 */
	
	
	public class Node{
		public int i;
		public int j;
		public Node(int i, int j)
		{
			this.i=i;
			this.j=j;
		}
		
	}
	
	
	public void arrayDiff(int[] arr, int k)
	{
		ArrayList<Node> result=new ArrayList<Node>();
		int length=arr.length;
		int m;
		
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(i!=j)
				{
					m=arr[i]-arr[j];
					if(m==k)
					{
						Node n=new Node(arr[i], arr[j]);
						result.add(n);
					}
				}
			}
		}
		
		
		for(Node n : result)
		{
			System.out.println("I "+n.i+" J "+n.j);
		}
		
		//return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={1,5,3,4,2};
		//ArrayList<Node> preeti=
				new ArrayDiffEqualsK().arrayDiff(arr, 3);
		
		/*for(Node n : preeti)
		{
			System.out.println("I "+n.i+" J "+n.j);
		}*/
		

	}
}
