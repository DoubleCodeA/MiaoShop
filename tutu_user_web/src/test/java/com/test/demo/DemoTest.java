package com.test.demo;

import org.junit.Test;

import java.util.*;

public class DemoTest {
    @Test
    public void testDemo(){
        String str = "1,2,3,1,2,3,1,25,6,8,3,5";
        List<String> strings = Arrays.asList(str.split(","));
//        for (String string : strings) {
//            System.out.print(string);
//            System.out.println();
//        }
        HashSet<String> set = new HashSet<String>(strings);
        for (String s : set) {
            System.out.println(s);
        }


    }
}
