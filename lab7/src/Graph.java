import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.*;


public class Graph {
    private final List<Edge> edges = new ArrayList<>();
    public int firstFrequency[] ;
    public int secondFrequency[] ;

//    Graph(int n) {
//            firstFrequency = new int[n];
//            secondFrequency = new int[n];
//    }

    boolean isSpanningTree() {

       /* for (Edge muchie : edges ) {
            firstFrequency[muchie.getFirstVertex()]++;
            secondFrequency[muchie.getSecondVertex()]++;

        }*/
        return false;
    }
    void add(Edge e) {
        edges.add(e);
    }

    void shuffle() {
        Collections.shuffle(edges);
    }
    Edge pollFirst() {
        Edge aux =  edges.get(0);
        edges.remove(0);
        return  aux;
    }


    void printGraph() {
        System.out.println("Print graf :");
        for( Edge muchie : edges ) {
            System.out.println(muchie.getFirstVertex() + "   " + muchie.getSecondVertex());
        }
    }
    void printGraph(String name) {
        System.out.println(name + "Print graf :");
        for( Edge muchie : edges ) {
            System.out.println(muchie.getFirstVertex() + "   " + muchie.getSecondVertex());
        }
    }


}
