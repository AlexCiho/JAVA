package com.company;

public class Main {

    public static void main(String[] args) {
	Hotel v1 = new Hotel("California");
	Museum v2 = new Museum("Louvre");
	TravelMap map = new TravelMap();
    map.addNode(v1);
    map.addNode(v2);
    map.addEdge(v1, v2, 15);
    }
}
