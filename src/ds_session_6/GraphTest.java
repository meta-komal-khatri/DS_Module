package ds_session_6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void test() {
		Graph graph=new Graph(5);
		graph.addEdge(0,1,6);
		graph.addEdge(1,2,6);
		graph.addEdge(0,3,3);
		graph.addEdge(0,2,3);
		assertEquals(false,graph.isConnected());
		List<Integer> array=new LinkedList<Integer>(Arrays.asList(0,1,2,3));
	
			assertEquals(array.toString(),graph.reachableVertices(0).toString());
		
	}

}
