package com.company;

public class Hotel extends Node implements Classifiable {
    Rank clas;
    public  Hotel (String name){
        super(name);
    }

    @Override
    public void setClass(Rank clas) {

    }
}
