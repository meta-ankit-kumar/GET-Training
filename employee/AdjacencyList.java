package employee;
/**
 * Class to represent adjacency list
 * @author ankit.kumar_metacube
 *
 */
public class AdjacencyList {
	
	public AdjacencyNode headVertex;
	private AdjacencyNode lastVertex;
	
	/**
	 * Initialize a AdjacencyList
	 */
	public AdjacencyList() {
		this.headVertex = null;
	}
	
	
	/**
	 * Add vertex into Adjacency List
	 * @param vertex int
	 */
	public void add(int vertex){
		AdjacencyNode adjacencyNode = new AdjacencyNode(vertex);
		adjacencyNode.nextVertex = null;
		if(this.headVertex == null){
			this.headVertex = adjacencyNode;
			this.lastVertex = adjacencyNode;
		}
		else{
			this.lastVertex.nextVertex = adjacencyNode;
			this.lastVertex = adjacencyNode;
		}
	}
	
}