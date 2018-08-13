package ds_session_6;

import java.util.LinkedList;
import java.util.List;


public class Graph1{
	int numberOfVertices;
	int [][]graph;
	List<Integer> reachableVertices;
	
	Graph1(int numberOfVeritces){
		this.numberOfVertices=numberOfVeritces;
		reachableVertices=new LinkedList<Integer>();
		graph=new int[numberOfVertices][numberOfVertices];
		initialize();
	}

	/**
	 * initialize graph edges with 0 
	 */
	private void initialize() {
		for(int i=0;i<numberOfVertices;i++) {
			for(int j=0;j<numberOfVertices;j++) {
				graph[i][j]=0;
			}
		}
	}
	
	/**
	 * add edges to graph
	 * @param source source of edge
	 * @param destination destination of edge
	 * @param weightOfGraph 
	 */
	public void addEdge(int source,int destination,int weightOfGraph) {
		graph[source][destination]=weightOfGraph;
		graph[destination][source]=weightOfGraph;
	}

	/**
	 * traverse graph using depth first search
	 * @param sourceVertices starting vertex for traversing
	 * @return true if graph is connected
	 */
	public boolean DFS(int sourceVertices)
	{
		//track that specific vertex is visited earlier or not
		boolean visited[] = new boolean[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++) {
			visited[i]=false;
		}
		DFSUtility(sourceVertices, visited);
		for(int i=0;i<numberOfVertices;i++) {
			if(visited[i]==false) {
				return false;
			}	
		}
		return true;
	}
	
	/**
	 * utility method for DFS 
	 * @param source
	 * @param visited
	 */
	private void DFSUtility(int source,boolean visited[]) {
		//reachable vertices from given source
		reachableVertices.add(source);
		visited[source] = true;
		for(int i=0;i<numberOfVertices;i++)
		{
			if(graph[source][i]!=0) {
				int vertice = i;
				if (!visited[vertice])
					DFSUtility(vertice, visited);
			}
		}
	}

	/**
	 * checks that graph is connected or not
	 * @return true if connected else false
	 */
	public boolean isConnected() {
		if(!check()) {
			throw new AssertionError("Graph is empty");
		}
		return DFS(1);
	}

	/**
	 * finds all the vertices that are reachable from given vertex
	 * @param vertice
	 * @return list of vertices that are reachable from specific nodes
	 */
	public List<Integer> reachableVertices(int vertice){
		if(!check()) {
			throw new AssertionError("Graph is empty");
		}
		reachableVertices=new LinkedList<Integer>();
		DFS(vertice);


		return reachableVertices;
	}
	
	/**
	 * find minimum spanning tree of graph
	 * it contains n-1 edges if there are n vertices in graph
	 * graph must be connected
	 * @return 2-D array each row representing edge
	 */
	public int[][] primMST() {
		if(!check()) {
			throw new AssertionError("Graph is empty");
		}
		//denotes source vertex for each index vertex
		int parent[]=new int[numberOfVertices];
		
		//weight of each edge
		int key[]=new int [numberOfVertices];
		boolean []mstSet=new boolean[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++) {
			parent[i]=0;
			key[i]=Integer.MAX_VALUE;
			mstSet[i]=false;
		}
		parent[0]=-1;
		key[0]=0;
		int [][]MSTArray=MST(parent,key,graph,mstSet);
		return MSTArray;
	}

	/**
	 * utility method for primMST
	 * @param parent array denotes source vertex for each index
	 * @param key weight of edge 
	 * @param graph
	 * @param mstSet
	 * @return 2-D array each row representing edge
	 */
	private int[][] MST(int []parent,int []key,int [][]graph,boolean []mstSet) {
		for (int count = 0; count < numberOfVertices-1; count++)
		{
			int newSource = minKey(key, mstSet);
			mstSet[newSource] = true;
			for (int v = 0; v < numberOfVertices; v++) {
				if (graph[newSource][v]!=0 && mstSet[v] == false && graph[newSource][v] <  key[v]) {
					parent[v]  = newSource;
					key[v] = graph[newSource][v];
				}
			}
		}
		int [][]MST=new int[numberOfVertices-1][2];
		for(int i=0;i<MST.length;i++) {
			MST[i][0]=parent[i+1];
			MST[i][1]=i+1;
		}
		return MST;
	}

	/**
	 * find shortest path between given source and destination vertices  
	 * @param source
	 * @param destination
	 * @return shortest path length
	 */
	public int shortestPath(int source,int destination) {
		if(!check()) {
			throw new AssertionError("Graph is empty");
		}
		if(source < numberOfVertices && destination<numberOfVertices) {
			int distance[] = new int[numberOfVertices];
			boolean[] sptSet = new boolean[numberOfVertices];
			for (int i = 0; i < numberOfVertices; i++)
			{
				distance[i] = Integer.MAX_VALUE;
				sptSet[i] = false;
			}
			distance[source] = 0;
			distance=shortestPathUtility(distance,sptSet,graph,source);
			return distance[destination];
		}
		throw new ArrayIndexOutOfBoundsException("Out Of Range");

	}
	
	/**
	 * utility method for shortesPath
	 * @param distance
	 * @param sptSet
	 * @param graph
	 * @param source
	 * @return
	 */
	private int[] shortestPathUtility(int []distance,boolean []sptSet,int [][]graph,int source) {
		for (int count = 0; count < numberOfVertices-1; count++) {
			int u = minKey(distance, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < numberOfVertices; v++) {
				if (!sptSet[v] && graph[u][v]!=0 && distance[u] != Integer.MAX_VALUE && distance[u]+graph[u][v] < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}
		return distance;
	}

	private int minKey(int []key,boolean []mstSet) {
		int min = Integer.MAX_VALUE;
		int min_index=0; 
		for (int v = 0; v < numberOfVertices; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
	
	private boolean check() {
		for(int i=0;i<numberOfVertices;i++) {
			for(int j=0;j<numberOfVertices;j++) {
				if(graph[i][j]>0) {
					return true;
				}
			}
		}
		return false;
	}

}
