package employee;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * J-unit Test cases for graph
 * @author ankit.kumar_metacube
 *
 */
public class GraphTest {

	@Test
	public void isConnectedTest() {
		
		Graph graph1 = new Graph(4, new Edge[]{new Edge(0, 1, 45)});
		assertEquals(false, graph1.isConnected());
		
		Graph graph2 = new Graph(4, new Edge[]{new Edge(0, 1, 45), new Edge(1,2,35), new Edge(3, 2, 30)});
		assertEquals(true, graph2.isConnected());
		
		Graph graph3 = new Graph(4, new Edge[]{new Edge(0, 1, 45), new Edge(3,1,35), new Edge(1, 2, 30)});
		assertEquals(true, graph3.isConnected());
	}
	
	@Test
	public void reachableTest(){
		Graph graph = new Graph(4, new Edge[]{new Edge(0, 1, 45), new Edge(1,2,35), new Edge(3, 2, 30)});
		
		assertArrayEquals(new Integer[]{1}, graph.reachable(0));
		assertArrayEquals(new Integer[]{0,2}, graph.reachable(1));
		assertArrayEquals(new Integer[]{1,3}, graph.reachable(2));
		assertArrayEquals(new Integer[]{2}, graph.reachable(3));
	}
	
	@Test
	public void shortestPathTest(){
		Graph graph = new Graph(9, new Edge[]{new Edge(0, 1, 4), new Edge(1,2,8), new Edge(0, 7, 8),
				new Edge(1, 7,11),new Edge(7, 8, 7),new Edge(6, 7, 1),new Edge(2, 8, 2),new Edge(6, 8, 6),
				new Edge(6, 5, 2),new Edge(2, 5, 4),new Edge(2, 3, 7),new Edge(3, 5, 14),
				new Edge(3, 4, 9),new Edge(4, 5, 10)});
		
		assertEquals(21,graph.shortestPath(0, 4));
		assertEquals(14,graph.shortestPath(0, 8));
	}
	

}