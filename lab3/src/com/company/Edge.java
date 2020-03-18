package com.company;

public class Edge {
    private Node nod1;
    private Node nod2;
    private int cost;

    public Node getNod1() {
        return nod1;
    }

    public void setNod1(Node nod1) {
        this.nod1 = nod1;
    }

    public Node getNod2() {
        return nod2;
    }

    public void setNod2(Node nod2) {
        this.nod2 = nod2;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Edge(Node n1, Node n2, int cos) {
        nod1 = n1;
        nod2 = n2;
        cost = cos;
    }
}
