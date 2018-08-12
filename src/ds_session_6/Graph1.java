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

	private void initialize() {
		for(int i=0;i<numberOfVertices;i++) {
			for(int j=0;j<numberOfVertices;j++) {
				graph[i][j]=0;
			}
		}
	}
	public void addEdge(int source,int destination,int weightOfGraph) {
		graph[source][destination]=weightOfGraph;
	}

	public boolean DFS(int sourceVertices)
	{
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
	private void DFSUtility(int source,boolean visited[]) {
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

	public boolean isConnected() {
		return DFS(1);
	}

	public List<Integer> reachableVertices(int vertice){
		reachableVertices=new LinkedList<Integer>();
		DFS(vertice);
		for(int i=0;i<reachableVertices.size();i++) {
			System.out.println(reachableVertices.get(i));
		}

		return reachableVertices;
	}
	public int[][] primMST() {
		int parent[]=new int[numberOfVertices];
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

	public int shortestPath(int source,int destination) {
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

}
