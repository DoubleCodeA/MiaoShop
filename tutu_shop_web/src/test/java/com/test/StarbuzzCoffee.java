package com.test;

import org.junit.Test;

import java.sql.SQLOutput;

public class StarbuzzCoffee {
    @Test
    public void test(){
        Beverage beverage = new Esppresso();
        System.out.println(beverage.getDescription()+" $"+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+" $"+beverage1.cost());
    }

}
