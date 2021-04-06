package employee;

import static org.junit.Assert.assertEquals;
//MainApp to print the graph
public class MainAppForGraph {

	public static void main(String[] args) {
		Graph graph2 = new Graph(4, new Edge[]{new Edge(0, 1, 45), new Edge(1,2,35), new Edge(3, 2, 30)});
		graph2.isConnected();
		
		Graph graph = new Graph(9, new Edge[]{new Edge(0, 1, 4), new Edge(1,2,8), new Edge(0, 7, 8),
				new Edge(1, 7,11),new Edge(7, 8, 7),new Edge(6, 7, 1),new Edge(2, 8, 2),new Edge(6, 8, 6),
				new Edge(6, 5, 2),new Edge(2, 5, 4),new Edge(2, 3, 7),new Edge(3, 5, 14),
				new Edge(3, 4, 9),new Edge(4, 5, 10)});
		Edge[] mstOfGraph  = graph.minimumSpanningTree();
		
		for(Edge edge : mstOfGraph){
			System.out.println(edge.vertex1 + " - " + edge.vertex2 + "\t" + edge.weight);
		}
	}

}
