/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dinesh Appavoo
 *
 */
public class DijkstraAlgorithm {

	/**
	 * @param args
	 */
	
	public static boolean[] pathDetermined;
	public static int noOfVertices,noOfEdges;
	public static Graph<Integer> graph=null;
	public static int[] d;
	public final static int INFINITY=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DijkstraAlgorithm dijkstra=new DijkstraAlgorithm();
		dijkstra.constructGraph();
		dijkstra.findDijkstraShortestPath();
	}
	
	public void constructGraph()
	{
		
		int u, v, w;
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();
			
			//For the next function 'doDepthFirstSearch'
			pathDetermined=new boolean[noOfVertices+1];
			d=new int[noOfVertices+1];
			
			
			graph=new Graph<Integer>(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			{
				u=scanner.nextInt();
				v=scanner.nextInt();
				w=scanner.nextInt();
				graph.addEdge(u, v, w);
				graph.addEdge(v, u, w);
			}
			break;
		}
		graph.printGraph();

	}

	/**
	 * Initialize a single source graph
	 */
	public void initializeSingleSource()
	{
		//Initialize source distance as zero
		d[1]=0; 
		
		//Initialize all vertices distance as infinity
		for(int i=1;i<=noOfVertices;i++)
		{
			d[i]=INFINITY;
		}
	}
	
	/**
	 * Method to relax an edge
	 * @param u
	 * @param v
	 * @param w
	 */
	public void doRelax(int u, int v, int w)
	{
		if(d[v]>d[u]+w)
			d[v]=d[u]+w;
	}
	
	/**
	 * Function to find the shortest path using Dijkstra's Algorithm
	 */
	public void findDijkstraShortestPath()
	{
		initializeSingleSource();
		for(int i=1;i<=noOfVertices;i++)
		{
			pathDetermined[i]=true;
			ArrayList<Edge> adjacentList=graph.getOutEdges(i);
			for(Edge e : adjacentList)
			{
				doRelax((Integer)e.u, (Integer)e.v, (Integer)e.w);
			}
			
		}
	}
	

}
