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
    boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        for(Edge edge: edges)
        {
            if(edge.getFirstVertex() == v || edge.getSecondVertex() == v)
            {
                if(visited[v] == false) {
                    visited[v] = true;
                }
                int next = edge.getFirstVertex();
                if(next == v) next = edge.getSecondVertex();
                if(visited[next] == false) {
                    if(isCyclicUtil(next,visited,v)) return true;
                }
                else if(next != parent) return true;
            }
        }
        return false;
    }
    boolean isSpanningTree(int n) {
        if(edges.size() != n-1) return false;
        Boolean visited[] = new Boolean[n+1];
        for (int i = 1; i <= n; i++)
            visited[i] = false;

        // The call to isCyclicUtil serves multiple purposes
        // It returns true if graph reachable from vertex 0
        // is cyclcic. It also marks all vertices reachable
        // from 0.
        if (isCyclicUtil(1, visited, 0))
            return false;

        // If we find a vertex which is not reachable from 0
        // (not marked by isCyclicUtil(), then we return false
        for (int u = 1; u <= n; u++)
            if (!visited[u])
                return false;

        return true;
    }
    boolean isClique(int n) {
        int no[] = new int[n+1],nr=0;
        for (int i = 1; i <= n; i++)
            no[i] = 0;
        for(Edge edge: edges) {
            no[edge.getFirstVertex()]++;
            no[edge.getSecondVertex()]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(no[i]!=0) {
                nr = no[i];
                break;
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(no[i]!=0 && no[i]!=nr) return false;
        }
        return true;
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
