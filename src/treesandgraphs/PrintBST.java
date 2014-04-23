/**
 * 
 */
package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dany
 *
 */
public class PrintBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] postOrder={6,1,2,5,9,4,11,10,3,13,12,14,17,16,19,20,18,15,8,7};
		int[] inOrder={1,6,2,4,5,9,7,8,3,10,11,12,13,14,15,16,17,18,19,20};
		TreeNode root=new CreateTreeGivenPostAndInOrder().createBinaryTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1);
		new PrintBST().doBFSPrint(root);
	}
	
	public void doBFSPrint(TreeNode root)
	{
		if(root==null)
			return;
		TreeNode currentNode=null;
		TreeNode left=null;
		TreeNode right=null;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(null);
		queue.add(root);
		while(!queue.isEmpty())
		{
			currentNode=queue.poll();
			if(currentNode==null)
			{
				System.out.println("");
			}else
			{
				left=currentNode.left;
				if(left==null)
					queue.add(new TreeNode(-1));
				else
					queue.add(left);
				right=currentNode.right;
				if(right==null)
					queue.add(new TreeNode(-1));
				else
					queue.add(right);
				System.out.print(currentNode.data);
			}
			queue.add(null);
			
		}
	}

}
