package com.company;

public class Main {

    public static void main(String[] args) {
	Hotel v1 = new Hotel("Hotel");
	Museum v2 = new Museum("Museum A");
	Museum v3 = new Museum("Museum B");
	Church v4 = new Church("Church A"),v5= new Church("Church B");
	Restaurant v6 = new Restaurant("Restaurant");
	TravelMap map = new TravelMap();
    map.addNode(v1);
    map.addNode(v2);
    map.addNode(v3);
    map.addNode(v4);
    map.addNode(v5);
    map.addNode(v6);
    map.addEdge(v1, v2, 15);
    map.addEdge(v1,v3,10);
    map.addEdge(v3,v2,1,false);
    map.addEdge(v3,v4,2);
    map.addEdge(v4,v5,1);
    map.addEdge(v5,v6,1);
    map.addEdge(v2,v6,10);
    map.distanceDijkstra(v3,v6);
    System.out.println();
    map.distanceFloyd();
    }
}
