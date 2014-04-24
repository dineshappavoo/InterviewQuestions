package treesandgraphs;

import java.util.ArrayList;

/**
 * @author Dany
 *
 */
public class Graph {

	
	public static ArrayList<Edge>[] adjacencyList=null;
	public int noOfVertices;
	
	
	public Graph(int noOfVertices)
	{
		adjacencyList=(ArrayList<Edge>[])new ArrayList[noOfVertices];
		this.noOfVertices=noOfVertices;
	}

	/**
	 * 
	 * @param u
	 * @param v
	 * @param w
	 * To add edges to the adjacency list graph
	 */
	public void addEdge(int u, int v, int w)
	{
		if(adjacencyList[u]==null)
			adjacencyList[u]=new ArrayList<Edge>();
		adjacencyList[u].add(new Edge(u, v, w));
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * To remove the edge from the graph
	 */
	public void removeEdge(int u, int v)
	{
		int indexToBeRemoved=-1;
		ArrayList<Edge> edgeList=adjacencyList[u];
		for(int i=0;i<adjacencyList[u].size();i++)
		{
			Edge e=edgeList.get(i);
			if(e.u==u&&e.v==v)
			{
				indexToBeRemoved=i;
			}
		}
		edgeList.remove(indexToBeRemoved);
	}
	
	public ArrayList<Edge> getOutEdges(int u)
	{
		return adjacencyList[u];
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * @return
	 * To get the weight given the u and v values
	 * 
	 */
	public int getWeight(int u, int v)
	{
		ArrayList<Edge> edgeList=adjacencyList[u];
		int weight=0;
		for(Edge e : edgeList)
		{
			if(e.v==v)
				weight=e.w;
		}
		return weight;
	}
	
	public void printGraph()
	{
		ArrayList<Edge> edgeList;
		for(int i=0;i<noOfVertices;i++)
		{
			edgeList=adjacencyList[i];
			for(Edge e : edgeList)
				System.out.println("u : "+e.u+" v : "+e.v+" w : "+e.w);
		}
	}
	/**
	 * 
	 * @param args
	 * Main function to test the graph
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
