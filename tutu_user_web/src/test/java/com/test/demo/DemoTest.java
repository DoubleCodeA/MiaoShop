package com.test.demo;

import org.junit.Test;

import java.util.*;

public class DemoTest {
//    @Test
//    public void testDemo2(){
//        int[] arr = {-11,-1,-8,9,7,6,0,2,-1,-8,9,7,6,0,2};
//        int i = 0;
//        int j = arr.length - 1;
//        int count = 0;
//        while (i < j) {
//            if (arr[i] < 0 && arr[j] > 0) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//            }
//            if (arr[i] >= 0) {
//                i++;
//            }
//            if (arr[j] < 0) {
//                j--;
//            }
//            count++;
//        }
//        System.out.println(count);
//        System.out.println(Arrays.toString(arr));
//
//    }
    @Test
    public void testDemo(){
//        String str = "1,2,3,1,2,3,1,25,6,8,3,5";
//        List<String> strings = Arrays.asList(str.split(","));
////        for (String string : strings) {
////            System.out.print(string);
////            System.out.println();
////        }
//        HashSet<String> set = new HashSet<String>(strings);
//        for (String s : set) {
//            System.out.println(s);
//        }

        int[] a = {-11,-1,-8,9,7,6,0,2,-1,-8,9,7,6,0,2};
        int b = 0;
        int c = a.length;
        int count = 0;
        for (int i = b; i < c; i++) {
            if (a[c-1] <0){
                c--;
            }
            i = b;
            if (a[i] > 0){
                b++;
            }else {
                int temp = a[i];
                a[i] = a[c-1];
                a[c-1] = temp;
            }
            count++;
        }
        System.out.println(count);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    @Test
    public void testDemo3(){

        int[] a = {-11,-1,-8,9,7,6,0,2,-1,-8,9,7,6,0,2};
        int b = 0;
        int c = a.length;
        int count = 0;
        for (int i = b; i < c; i++) {
            if (a[i] < 0 && a[c-1]>0){
                int temp = a[i];
                a[i] = a[c-1];
                a[c-1] = temp;
                i++;
                c--;
            }
            if (a[i] >= 0) {
                i++;
            }
            if (a[c] < 0) {
                c--;
            }
            count++;
        }
        System.out.println(count);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
