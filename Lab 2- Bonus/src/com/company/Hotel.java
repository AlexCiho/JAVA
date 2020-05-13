package com.company;

public class Hotel extends Node implements Classifiable {
    Rank rank;
    public  Hotel (String name){
        super(name);
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public Rank getRank() {
        return this.rank;
    }
}
