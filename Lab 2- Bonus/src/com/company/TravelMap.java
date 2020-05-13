package com.company;

import java.util.*;
import java.util.Collections;

public class TravelMap  {
    private List<Node> myListNodes = new ArrayList<>();
    private Map<Node,List<Edge>> myEdges = new HashMap<Node,List<Edge>>();
    private Map<Node,Integer> indexByNode = new HashMap<Node,Integer>();
    private Map<Integer,Node> nodeByIndex = new HashMap<Integer,Node>();
    public void addNode(Node n1) {
        myListNodes.add(n1);
        myEdges.put(n1,new ArrayList<Edge>());
        indexByNode.put(n1,myListNodes.size()-1);
        nodeByIndex.put(myListNodes.size()-1,n1);
    }
    public void addEdge(Node n1, Node n2, int cost) {
        Edge e1 = new Edge(n2,cost);
        myEdges.get(n1).add(e1);
        Edge e2 = new Edge(n1,cost);
        myEdges.get(n2).add(e2);
    }
    public void addEdge(Node n1, Node n2, int cost,boolean sense) {
        Edge e1 = new Edge(n1,cost);
        myEdges.get(n1).add(e1);
    }
    public List<Node> getNodes(){
        List<Node> sortedList = new ArrayList<>(this.myListNodes);
        Collections.sort(sortedList,new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sortedList;
    }
    public void distanceDijkstra(Node n1, Node n2)
    {
        int inf = 0x3f3f3f3f;
        int dist[] = new int[myListNodes.size()];
        int prev[] = new int[myListNodes.size()];
        Arrays.fill(dist,inf);
        Arrays.fill(prev,-1);
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(dist[o1]>dist[o2]) return 1;
                else return -1;
            }
        });

        int start = indexByNode.get(n1), end = indexByNode.get(n2);
        dist[start]=0;
        Q.add(start);
        while(Q.size() > 0)
        {
            int curr = Q.poll();
            Node currNode= nodeByIndex.get(curr);
            for(Edge edge: myEdges.get(currNode))
            {
                int next = indexByNode.get(edge.getNode());
                if(dist[next] > dist[curr] + edge.getCost())
                {
                    dist[next] = dist[curr] + edge.getCost();
                    Q.add(next);
                    prev[next] = curr;
                }
            }
        }
        System.out.println(dist[end]);
        path(end,prev);
    }
    public void path(int curr, int prev[])
    {
        if(prev[curr] != -1) path(prev[curr],prev);
        if(prev[curr] != -1) System.out.print(" -> ");
        System.out.print(nodeByIndex.get(curr).getName());
    }
    public void distanceFloyd()
    {
        int[][] dist = new int[myListNodes.size()][myListNodes.size()];
        for(Node node: myListNodes)
        {
            for(Edge edge : myEdges.get(node))
            {
                dist[indexByNode.get(node)][indexByNode.get(edge.getNode())] = edge.getCost();
            }
        }
        int N = myListNodes.size();
        for(int k=0;k<N;k++)
        {
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if( i!=j && dist[i][k]!=0 && dist[k][j]!=0 && (dist[i][k]+dist[k][j]<dist[i][j] || dist[i][j]==0)) dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++) System.out.print(dist[i][j]+" ");
            System.out.print("\n");
        }
    }
}
