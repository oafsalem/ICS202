
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.TopologicalOrderIterator;

import java.util.List;
import java.util.PriorityQueue;

public class Solutions {
    public static void main(String[] args) {

        System.out.println("Question One:");
        SimpleGraph<Character, DefaultEdge> g =
                new SimpleGraph<Character, DefaultEdge>(DefaultEdge.class);

        char i1 = 'A';
        char i2 = 'B';
        char i3 = 'C';
        char i4 = 'D';
        char i5 = 'E';
        char i6 = 'F';
        char i7 = 'G';
        char i8 = 'H';
        char i9 = 'I';

        // add the vertices
        g.addVertex(i1);
        g.addVertex(i2);
        g.addVertex(i3);
        g.addVertex(i4);
        g.addVertex(i5);
        g.addVertex(i6);
        g.addVertex(i7);
        g.addVertex(i8);
        g.addVertex(i9);

        g.addEdge(i1, i2);
        g.addEdge(i1, i4);
        g.addEdge(i1, i5);
        g.addEdge(i2, i3);
        g.addEdge(i2, i5);
        g.addEdge(i3, i6);
        g.addEdge(i4, i7);
        g.addEdge(i7, i8);
        g.addEdge(i8, i9);


        System.out.println(g.toString());

        BreadthFirstIterator bfsi = new BreadthFirstIterator(g, i1);
        System.out.println("Breadth First Traversal:");
        while (bfsi.hasNext())
            System.out.print(bfsi.next() + " ");
        DepthFirstIterator dfi = new DepthFirstIterator(g, i1);
        System.out.println("\nDepth First Traversal:");
        while (dfi.hasNext())
            System.out.print(dfi.next() + " ");

        System.out.println("\nQuestion 2:");
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> sdwg = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        String a1 = "a";
        String b1 = "b";
        String c1 = "c";
        String d1 = "d";
        String e1 = "e";
        String f1 = "f";
        String g1 = "g";
        String h1 = "h";

        sdwg.addVertex(a1);
        sdwg.addVertex(b1);
        sdwg.addVertex(c1);
        sdwg.addVertex(d1);
        sdwg.addVertex(e1);
        sdwg.addVertex(f1);
        sdwg.addVertex(g1);
        sdwg.addVertex(h1);

        sdwg.setEdgeWeight(sdwg.addEdge(a1, b1), 1.0);
        sdwg.setEdgeWeight(sdwg.addEdge(a1, e1), 10.0);
        sdwg.setEdgeWeight(sdwg.addEdge(b1, e1), 8.0);
        sdwg.setEdgeWeight(sdwg.addEdge(e1, c1), 2.0);
        sdwg.setEdgeWeight(sdwg.addEdge(c1, f1), 2.0);
        sdwg.setEdgeWeight(sdwg.addEdge(f1, h1), 5.0);
        sdwg.setEdgeWeight(sdwg.addEdge(e1, d1), 15.0);
        sdwg.setEdgeWeight(sdwg.addEdge(e1, g1), 3.0);
        sdwg.setEdgeWeight(sdwg.addEdge(g1, f1), 4.0);

        System.out.println(sdwg.toString());
        DijkstraShortestPath dsp = new DijkstraShortestPath(sdwg);
        List s = dsp.getPath(a1, h1).getEdgeList();
        List s1 = dsp.getPath(b1, f1).getEdgeList();
        try {
            List s2 = dsp.getPath(g1, c1).getEdgeList();
            System.out.println("Easiest path from g to c is" + s2);
        } catch (Exception e) {
            System.out.println("This path doesn't exist");
        }
        System.out.println("Easiest path from a to h is" + s);
        System.out.println("Easiest path from b to f is" + s1);

        System.out.println("Question 3:");
        System.out.println("Part a");
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> sdwg2 = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        sdwg2.addVertex(a1);
        sdwg2.addVertex(b1);
        sdwg2.addVertex(c1);
        sdwg2.addVertex(d1);
        sdwg2.setEdgeWeight(sdwg2.addEdge(a1, b1), 2.0);
        sdwg2.setEdgeWeight(sdwg2.addEdge(a1, d1), 8.0);
        sdwg2.setEdgeWeight(sdwg2.addEdge(a1, c1), 2.0);
        sdwg2.setEdgeWeight(sdwg2.addEdge(b1, c1), 1.0);
        sdwg2.setEdgeWeight(sdwg2.addEdge(b1, d1), 3.0);
        sdwg2.setEdgeWeight(sdwg2.addEdge(c1, d1), 4.0);
        System.out.println("Part b");

        KruskalMinimumSpanningTree kmst = new KruskalMinimumSpanningTree(sdwg2);
        SpanningTreeAlgorithm.SpanningTree st = kmst.getSpanningTree();
        System.out.println("\nSpanning Tree = " + st.getEdges());
        System.out.println("\nCost = " + st.getWeight());

        System.out.println("Question 3");
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> sdwg3 = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        String MATH101 = "MATH101";
        String ICS102 = "ICS102";
        String COE202 = "COE202";
        String ICS201 = "ICS201";
        String ICS253 = "ICS253";
        String ICS202 = "ICS202";
        String ICS233 = "ICS233";
        String ICS431 = "ICS431";
        String ICS353 = "ICS353";
        String ICS343 = "ICS343";
        String ICS444 = "ICS444";

        sdwg3.addVertex(ICS102);
        sdwg3.addVertex(ICS201);
        sdwg3.addVertex(ICS202);
        sdwg3.addVertex(ICS233);
        sdwg3.addVertex(ICS431);
        sdwg3.addVertex(ICS253);
        sdwg3.addVertex(ICS353);
        sdwg3.addVertex(ICS343);
        sdwg3.addVertex(ICS444);
        sdwg3.addVertex(COE202);
        sdwg3.addVertex(MATH101);

        sdwg3.addEdge(ICS102, ICS201);
        sdwg3.addEdge(ICS102, ICS253);
        sdwg3.addEdge(ICS253, ICS353);
        sdwg3.addEdge(ICS201, ICS202);
        sdwg3.addEdge(ICS201, ICS233);
        sdwg3.addEdge(ICS201, ICS343);
        sdwg3.addEdge(ICS202, ICS353);
        sdwg3.addEdge(ICS343, ICS444);
        sdwg3.addEdge(COE202, ICS233);
        sdwg3.addEdge(ICS233, ICS431);
        sdwg3.addEdge(ICS431, ICS444);

        TopologicalOrderIterator toi = new TopologicalOrderIterator(sdwg3);

        while (toi.hasNext())
            System.out.print(toi.next() + " ");


        System.out.println("\nQuestion 4");
        PriorityQueue<String> pq = new PriorityQueue<String>();
        while (toi.hasNext()){
            pq.add((String)toi.next());
        }
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        // no idea why its empty.... and its not printing anything
    }
}
