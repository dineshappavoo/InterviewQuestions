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
public class DepthFirstSearch {

	/**
	 * @param args
	 */
	public static boolean[] visited;
	public static int[] parent;
	public static int noOfVertices,noOfEdges;
	public static Graph<Integer> graph=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepthFirstSearch dfs=new DepthFirstSearch();
		dfs.constructGraph();
		ArrayList<Integer> path=dfs.doDepthFirstSearch(null, 0, 1);
		if(path!=null)
		for(int n : path)
		{
			System.out.println(n);
		}
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
			visited=new boolean[noOfVertices+1];
			parent=new int[noOfVertices];
			
			
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

	public ArrayList<Integer> doDepthFirstSearch(ArrayList<Integer> path, int source, int dest)
	{

		if(path==null)
			path=new ArrayList<Integer>();
		visited[source]=true;
		path.add(source);
		ArrayList<Edge> outEdges=graph.getOutEdges(source);
		if(outEdges!=null)
		for(Edge e : outEdges)
		{
			if(e.v.compareTo(dest)==0)
			{
				path.add((Integer)e.v);
				return path;
			}
			else
			{
				doDepthFirstSearch(path, (Integer)e.v, dest);
			}
		}
		return null;

		
	}
	
	
}
