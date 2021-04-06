package employee;

import java.util.ArrayList;

/**
 * Class which implements graph interface
 * @author ankit.kumar_metacube
 *
 */
public class Graph implements GraphInterface{
	//number of vertices in the graph
	private final int numberOfVertices;
	//edges of the graph
	private final Edge[] edges;
	//Adjacency list representation of the graph
	private AdjacencyList[] adjacencyList;
	
	/**
	 * Constructor 
	 * @param vertices int, number of vertices greater than 0, vertices will be 0,1,2.....numberOfVertices - 1 
	 * @param edges Edge[], array of edges
	 */
	public Graph(int numberOfVertices, Edge[] edges) {
		this.edges = edges;
		this.numberOfVertices = numberOfVertices;
		this.adjacencyList = new AdjacencyList[this.numberOfVertices];
		for (int index = 0; index < numberOfVertices ; index++)  { 
            adjacencyList[index] = new AdjacencyList(); 
        } 
		for(Edge edge : this.edges){
			adjacencyList[edge.vertex1].add(edge.vertex2);
			adjacencyList[edge.vertex2].add(edge.vertex1);
		}
	}

	@Override
	public boolean isConnected() {
		
		boolean isConnected = true;
		boolean[] verticesVisited = new boolean[this.numberOfVertices];
		
		for(int index = 0; index < verticesVisited.length; index++){
			verticesVisited[index] = false;
		}
		
		DFS(0,verticesVisited);
		
		for(int index = 0; index < verticesVisited.length; index++){
			if(verticesVisited[index] == false){
				isConnected = false;
				break;
			}
		}
		return isConnected;
	}

	/**
	 * Method for DFS Traversal
	 * @param source int, source vertex
	 * @param verticesVisited bollean[]
	 */
	private void DFS(int source, boolean[] verticesVisited){
		if(verticesVisited[source] == true){
			return;
		}
		verticesVisited[source] = true;
		
		AdjacencyNode nextNode = this.adjacencyList[source].headVertex;
		
		while(nextNode != null){
			DFS(nextNode.vertex, verticesVisited);
			nextNode = nextNode.nextVertex;
		}
	}
	
	@Override
	public Integer[] reachable(int source) throws AssertionError {
		if(source < 0 || source >= this.numberOfVertices){
			throw new  AssertionError("Invalid source vertex");
		}
		ArrayList<Integer> reachableVertices = new ArrayList<Integer>();
		
		AdjacencyNode nextNode = this.adjacencyList[source].headVertex;
		
		while(nextNode != null){
			reachableVertices.add(nextNode.vertex);
			nextNode = nextNode.nextVertex;
		}
		
		return reachableVertices.toArray(new Integer[reachableVertices.size()]);
	}

	@Override
	public Edge[] minimumSpanningTree() {
		if(!isConnected()){
			return new Edge[0];
		}
		
        int minimumSpanningTree[] = new int[this.numberOfVertices]; 
        int key[] = new int[this.numberOfVertices];  
        Boolean verticesUsed[] = new Boolean[this.numberOfVertices]; 
  
        for (int index = 0; index < this.numberOfVertices; index++) { 
            key[index] = Integer.MAX_VALUE; 
            verticesUsed[index] = false; 
        } 
  
        
        key[0] = 0; 
  
        
        for (int count = 0; count < this.numberOfVertices - 1; count++) { 
           
            int minVertex = minKey(key, verticesUsed);  
            verticesUsed[minVertex] = true; 
  
           
            for (int vertex = 0; vertex < this.numberOfVertices; vertex++) {
            	
            	//finding edge with given vertices
            	Edge graphUV = null;  //  U = minVertex and V = any vertex in vertices
            	for(Edge edge : this.edges){
            		if((edge.vertex1 == minVertex && edge.vertex2 == vertex) || edge.vertex1 == vertex && edge.vertex2 == minVertex){
            			graphUV = edge;
            			break;
            		}
            	}
            	
                if (graphUV != null && verticesUsed[vertex] == false && graphUV.weight < key[vertex]) { 
                	minimumSpanningTree[vertex] = minVertex; 
                    key[vertex] = graphUV.weight; 
                }
            } 
        } 
  
        return getEdgesOfMST(minimumSpanningTree);
	}

	/**
	 * Helper Metohd to get vetrex with min Key
	 * @param key int[], key values
	 * @param mstSet Boolean[], for check if vertex is already in use or not
	 * @return int, vertex with minimum key
	 */
	private int minKey(int[] key, Boolean[] mstSet) 
    { 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int index = 0; index < this.numberOfVertices; index++) 
            if (mstSet[index] == false && key[index] < min) { 
                min = key[index]; 
                min_index = index; 
            } 
  
        return min_index; 
    } 
	
	/**
	 * Get Edge of a minimum Spanning tree
	 * @param minimumSpanningTree int[]
	 * @return Edge[], array of Edges
	 */
	private Edge[] getEdgesOfMST(int[] minimumSpanningTree){
		
		Edge[] edgesOfMST = new Edge[this.numberOfVertices - 1];
		
		for (int i = 1; i < this.numberOfVertices; i++){ 
			
			Edge graphUV = null;
        	for(Edge edge : this.edges){
        		if( (edge.vertex1 == minimumSpanningTree[i] && edge.vertex2 == i) || (edge.vertex2 == minimumSpanningTree[i] && edge.vertex1 == i)){
        			graphUV = edge;
        			break;
        		}
        	}
        	
            edgesOfMST[i-1] = new Edge(minimumSpanningTree[i], i, graphUV.weight );
		}
		
		return edgesOfMST;
	}
		
			
	@Override
	public int shortestPath(int source, int destination) {
		
        int distance[] = new int[this.numberOfVertices]; 
        
        Boolean processed[] = new Boolean[this.numberOfVertices];
        
        for (int i = 0; i < this.numberOfVertices; i++) 
        {
            distance[i] = Integer.MAX_VALUE;
            processed[i] = false;
        }
        
        distance[source] = 0;
        
        for (int count = 0; count < this.numberOfVertices - 1; count++) 
        {
            int shortestDistanceNode = minKey(distance, processed);
        
            processed[shortestDistanceNode] = true;
            AdjacencyNode adjacentEdges = this.adjacencyList[shortestDistanceNode].headVertex;
            
            while(adjacentEdges != null) 
            {
                int vertex = adjacentEdges.vertex;
                
                Edge listEdge = null;  //  U = minVertex and V = any vertex in vertices
            	for(Edge edge : this.edges){
            		if((edge.vertex1 == shortestDistanceNode && edge.vertex2 == vertex) || edge.vertex1 == vertex && edge.vertex2 == shortestDistanceNode){
            			listEdge = edge;
            			break;
            		}
            	}
            	
                
                if (!processed[vertex] && distance[shortestDistanceNode] + listEdge.weight < distance[vertex]){
                    distance[vertex] = distance[shortestDistanceNode] + listEdge.weight;
                    }
                adjacentEdges = adjacentEdges.nextVertex;                    
            }            
        }
        
        return distance[destination];
	}
}