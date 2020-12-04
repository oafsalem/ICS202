import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree; 

public class GraphsExample02 {
	public static void main(String[] args) {
		DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> g = 
			new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        String city1 = "Dammam";
        String city2 = "Riyadh";
        String city3 = "Jeddah";
        String city4 = "Madinah";
        String city5 = "Hail";

        // add the vertices
        g.addVertex(city1);
        g.addVertex(city2);
        g.addVertex(city3);
        g.addVertex(city4);
        g.addVertex(city5);
        
        g.setEdgeWeight(g.addEdge(city1, city2), 4.0);
        g.setEdgeWeight(g.addEdge(city2, city3), 8.0);
        g.setEdgeWeight(g.addEdge(city3, city4), 5.0);
        g.setEdgeWeight(g.addEdge(city4, city5), 1.0);
        g.setEdgeWeight(g.addEdge(city1, city3), 10.0);
        g.setEdgeWeight(g.addEdge(city3, city5), 7.0);
      
      	System.out.println(g.toString());
      	
      	DijkstraShortestPath dsp = new DijkstraShortestPath(g);
      	GraphPath gp = dsp.getPath(city1, city5);
      	System.out.println("\nShortest Path between Dammam and Hail = " + gp.getEdgeList());
      	System.out.println("Length = "+ gp.getWeight());
      	
      	System.out.println("\nShortest Path between Riyadh and Hail = "
      		+DijkstraShortestPath.findPathBetween(g, city2, city5)); 
      	
      
      	KruskalMinimumSpanningTree kmst = new KruskalMinimumSpanningTree(g);
      	SpanningTree st = kmst.getSpanningTree();
      	System.out.println("\nKruskal's MST = " +st.getEdges());
      	System.out.println("\nKruskal's MST Cost = " +st.getWeight());
      	
      	
      	
	}
}