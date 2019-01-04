package com.test.demo;

import org.junit.Test;

public class Singleton {
    private static Singleton singleton;
    private Singleton(){
        System.out.println("sss");
    }
    public static Singleton getSingleton(){
        if (singleton==null){
            singleton=new Singleton();

        }
        return singleton;
    }
    public void ss(){
        new Singleton();
    }
}