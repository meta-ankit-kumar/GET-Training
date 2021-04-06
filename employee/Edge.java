package employee;

/**
 * Class to represent edge of the graph
 * @author ankit.kumar_metacube
 *
 */
public class Edge {
	//starting vertex
	public final int vertex1;
	//ending vertex
	public final int vertex2;
	//weight of the edge
	public final int weight;
	
	/**
	 * Constructor
	 * @param vertex1 int
	 * @param vertex2 int
	 * @param weight int
	 */
	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	
}
