package com.company;

public class Museum extends Node implements Payable {
    private double price;
    public Museum (String name){
        super(name);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
