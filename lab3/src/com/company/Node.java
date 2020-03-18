package com.company;

public class Node {
    private String name;
    private int longitutde;
    private  int latitude;

    public Node(String name) {
        this.setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitutde() {
        return longitutde;
    }

    public void setLongitutde(int longitutde) {
        this.longitutde = longitutde;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
