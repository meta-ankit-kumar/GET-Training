package employee;

import java.util.ArrayList;


/**
 * Graph interface
 * @author ankit.kumar_metacube
 *
 */
public interface GraphInterface
{
    
    /**
     * method to check whether the graph is connected or not
     * @return boolean, true if graph is connected otherwise false
     */
    public boolean isConnected();
    
    
    /**
     * method to find all the vertices which are reachable from the source vertex
     * @param int, source vertex
     * @return int[], list of reachable vertices
     * @throws AssertionError if source is invalid
     */
    public Integer[] reachable(int source) throws AssertionError;
    
    
    /**
     * method to get the minimum spanning tree 
     * @return Edge[], list of edges in minimum spanning tree
     */
    public Edge[] minimumSpanningTree();
    
    
    /**
     * method to find the distance of the shortest path from source to destination
     * @param source int, source vertex
     * @param destination int, destination vertex
     * @return int, distance of shortest path
     */
    public int shortestPath(int source, int destination);
}