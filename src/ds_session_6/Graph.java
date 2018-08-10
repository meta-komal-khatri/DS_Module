package ds_session_6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph{
	int numberOfVertices;
	List<Integer> []edgeList;
	List<Integer> reachableVertices;
	@SuppressWarnings("unchecked")

	Graph(int numberOfVeritces){
		this.numberOfVertices=numberOfVeritces;
		reachableVertices=new LinkedList<Integer>();
		edgeList=new LinkedList[numberOfVeritces];
		
		for(int i=0;i<numberOfVeritces;i++) {
			edgeList[i]=new LinkedList<Integer>();
		}	
	}

	public void addEdge(int source,int destination,int weightOfGraph) {
		Edge edge=new Edge(source,destination,weightOfGraph);
		edgeList[source].add(destination);
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
		System.out.println(source);
		reachableVertices.add(source);
		visited[source] = true;
        Iterator<Integer> edgeIterator = edgeList[source].listIterator();
        while (edgeIterator.hasNext())
        {
        	 int vertice = edgeIterator.next();
             if (!visited[vertice])
                 DFSUtility(vertice, visited);
        }
    }
	
	public boolean isConnected() {
		return DFS(0);
	}
	public List<Integer> reachableVertices(int vertice){
		reachableVertices=new LinkedList<Integer>();
		DFS(vertice);
		
		return reachableVertices;
	}
	
}
