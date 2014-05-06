/**
 * 
 */
package facebookchallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Dinesh Appavoo
 *
 */
public class Solution {


	public static int noOfVertices,noOfEdges;
	public static Graph graph=null;
	public static HashMap<Integer, Integer> armyA=null;
	public static HashMap<Integer, Integer> armyB=null;


	public static boolean isArmyAandBConnected=false;


	public static void main(String[] args) throws FileNotFoundException {

		new Solution().constructGraph("/users/dany/downloads/ByteLand_testcases/input000.txt");
	}

	public void constructGraph(String sFile) throws FileNotFoundException
	{
		File file=new File(sFile);
		int u, v;
		String army;
		int noTestCases;
		Scanner scanner=new Scanner(file);

		noTestCases=scanner.nextInt();
		for(int t=0;t<noTestCases;t++)
		{
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();

			armyA=new HashMap<Integer, Integer>();
			armyB=new HashMap<Integer, Integer>();
			isArmyAandBConnected=false;


			graph=new Graph(noOfVertices);

			for(int m=1;m<=noOfVertices;m++)
			{
				army=scanner.next();
				if(army.equals("A"))
				{
					armyA.put(m, scanner.nextInt());
				}else if(army.equals("B"))
				{
					armyB.put(m, scanner.nextInt());
				}
			}

			for(int i=0;i<noOfEdges;i++)
			{
				u=scanner.nextInt();
				v=scanner.nextInt();
				graph.addEdge(u, v);
				graph.addEdge(v, u);
			}

			System.out.println(processGraph());

			//break;
		}
		//graph.printGraph();
	}



	public int processGraph()
	{
		//ArrayList<Integer> costlist=new ArrayList<Integer>();
		int selfCostValue=0, inArmyCostValue=0,finalCost=0;
		ArrayList<Integer>[] adjacencyList=graph.getAdjacencylist();
		for(int i=1;i<adjacencyList.length;i++)
		{
			ArrayList<Integer> list=adjacencyList[i];
			for(int j=0;j<list.size();j++)
			{

				int n=list.get(j);
				if(armyA.containsKey(i)&&armyB.containsKey(n))
					isArmyAandBConnected=true;
				if(i==n)
				{
					selfCostValue=(armyA.containsKey(i)?armyA.get(i):armyB.get(i));
				}else if(  (armyA.containsKey(i)&&armyA.containsKey(n))  ||  (armyB.containsKey(i)&&armyB.containsKey(n))  )
				{
					inArmyCostValue=armyA.containsKey(i)?(armyA.get(i)+armyA.get(n)):(armyB.get(i)+armyB.get(n));
				}


			}

		}
		if(!isArmyAandBConnected)
		{
			finalCost=0;
		}else
		{
			if(selfCostValue==0)
				return inArmyCostValue;
			else if(inArmyCostValue==0)
				return selfCostValue;
			else
				finalCost=selfCostValue<inArmyCostValue?selfCostValue:inArmyCostValue;
		}
		return finalCost;
	}
}