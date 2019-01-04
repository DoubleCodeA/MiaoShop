package com.test;

public class Esppresso extends Beverage {

    public Esppresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
