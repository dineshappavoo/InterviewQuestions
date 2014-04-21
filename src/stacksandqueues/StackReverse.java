/**
 * 
 */
package stacksandqueues;

import java.util.Stack;

/**
 * @author Dany
 *
 */

/*
 * ALGORITHM
 * for size n to 1
 *  Keep the first element in the variable v
 *  for 1 to n-1 pop from S and push to T
 *  push v to S
 *  pop all from T and push to S
 * 
 * return S
 */
public class StackReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> S=new Stack<Integer>();
		S.push(2);
		S.push(4);
		S.push(3);
		S.push(1);
		Stack<Integer> T=StackReverse.reverseStack(S);
		
		while(!T.isEmpty())
		{
			System.out.println(T.pop());
		}

	}
	
	public static Stack<Integer> reverseStack(Stack<Integer> S)
	{
		Stack<Integer> T = new Stack<Integer>();
		int v=0;
		
		int size=S.size();
		while(size>0)
		{
			v=S.pop();
			for(int i=0;i<size-1;i++)
			{
				T.push(S.pop());
			}
			S.push(v);
			while(!T.isEmpty())
			{
				S.push(T.pop());
			}
			size--;
		}
		//S.push(v); //To push
		
		return S;
		
	}

}
