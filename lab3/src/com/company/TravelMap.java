package com.company;

import java.util.*;
import java.util.Collections;

public class TravelMap  {
    List<Node> myListNodes = new ArrayList<>();
    List<Edge> myListEdges = new ArrayList<>();

    public void addNode(Node n1) {
        myListNodes.add(n1);
    }
    public void addEdge(Node n1, Node n2, int cost) {
        Edge e1 = new Edge(n1,n2,cost);
        myListEdges.add(e1);
    }
    public List<Node> getNodes(){
        return  myListNodes.sort(Comparator.comparing(Node::getName));
    }

}
