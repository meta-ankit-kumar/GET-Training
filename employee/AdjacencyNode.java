package employee;

/**
 * Class to represent a node of adjacency node
 * @author ankit.kumar_metacube
 *
 */
public class AdjacencyNode {
	
	public int vertex;
	public AdjacencyNode nextVertex;
	
	/**
	 * Constructor
	 * @param vertex int
	 */
	public AdjacencyNode(int vertex){
		this.vertex = vertex; 
	}
}
