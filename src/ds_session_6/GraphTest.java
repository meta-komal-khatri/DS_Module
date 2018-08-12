package ds_session_6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void isConnectedTest() {
		Graph1 graph=new Graph1(4);
		graph.addEdge(0,1,3);
		graph.addEdge(1,2,6);
		graph.addEdge(0,3,4);
		graph.addEdge(0,2,5);
		assertEquals(true,graph.isConnected());

		Graph1 graph1=new Graph1(5);
		graph1.addEdge(0,1,3);
		graph1.addEdge(1,2,6);
		graph1.addEdge(0,3,4);
		graph1.addEdge(0,2,5);

		//there is not connecting edge for vertice 5
		assertEquals(false,graph1.isConnected());

	}
	@Test
	public void reachableNodesTest() {
		Graph1 graph=new Graph1(4);
		graph.addEdge(0,1,3);
		graph.addEdge(1,2,6);
		graph.addEdge(0,3,4);
		graph.addEdge(0,2,5);
		List<Integer> array=new LinkedList<Integer>(Arrays.asList(0,1,2,3));
		assertEquals(array.toString(),graph.reachableVertices(0).toString());
		array=new LinkedList<Integer>(Arrays.asList(1,0,2,3));
		assertEquals(array.toString(),graph.reachableVertices(1).toString());
	}

	@Test
	public void minimumSpanningTreeTest() {
		Graph1 graph=new Graph1(4);
		graph.addEdge(0,1,3);
		graph.addEdge(1,2,6);
		graph.addEdge(0,3,4);
		graph.addEdge(0,2,5);
		assertArrayEquals(new int[][] {{0,1},{0,2},{0,3}},graph.primMST());
		graph=new Graph1(9);
		graph.addEdge( 0, 1, 4);
		graph.addEdge( 0, 7, 7);
		graph.addEdge( 1, 2, 8);
		graph.addEdge( 1, 7, 11);
		graph.addEdge( 2, 3, 7);
		graph.addEdge( 2, 8, 2);
		graph.addEdge( 2, 5, 4);
		graph.addEdge( 3, 4, 9);
		graph.addEdge( 3, 5, 14);
		graph.addEdge( 4, 5, 10);
		graph.addEdge( 5, 6, 2);
		graph.addEdge( 6, 7, 1);
		graph.addEdge( 6, 8, 6);
		graph.addEdge( 7, 8, 7);
		assertArrayEquals(new int[][] {{0,1},{5,2},{2,3},{3,4},{6,5},{7,6},{0,7},{2,8}},graph.primMST());
		graph=new Graph1(3);

	}
	
	@Test
	public void shortestPathTest() {
		Graph1 graph=new Graph1(4);
		graph.addEdge(0,1,3);
		graph.addEdge(1,2,6);
		graph.addEdge(0,3,4);
		graph.addEdge(0,2,5);
		assertEquals(3,graph.shortestPath(0, 1));
		graph=new Graph1(9);
		graph.addEdge( 0, 1, 4);
		graph.addEdge( 0, 7, 7);
		graph.addEdge( 1, 2, 8);
		graph.addEdge( 1, 7, 11);
		graph.addEdge( 2, 3, 7);
		graph.addEdge( 2, 8, 2);
		graph.addEdge( 2, 5, 4);
		graph.addEdge( 3, 4, 9);
		graph.addEdge( 3, 5, 14);
		graph.addEdge( 4, 5, 10);
		graph.addEdge( 5, 6, 2);
		graph.addEdge( 6, 7, 1);
		graph.addEdge( 6, 8, 6);
		graph.addEdge( 7, 8, 7);
		assertEquals(12,graph.shortestPath(1, 5));
		assertEquals(15,graph.shortestPath(1, 3));
		assertNotEquals(13,graph.shortestPath(1, 5));
	}
	
	@Test(expected=AssertionError.class)
	public void assertionErrorCheck() {
		Graph1 graph=new Graph1(3);
		graph.primMST();
		graph.isConnected();
		graph.reachableVertices(1);
	}

}
