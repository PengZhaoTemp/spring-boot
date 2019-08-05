package com.example.zhaop.test.controller;

import java.util.UUID;

public class ThisClass {

    public ThisClass(String a){
        System.out.println("11111111111");
    }

    public ThisClass(){
        this("a");
        System.out.println("2222222222222");
    }

    public static void aaa() {
        System.out.println("333333333333333333");
    }

    public void bbbbbb() {
        System.out.println("4444444444444444");
    }

    public static void main(String[] args) {
        //ThisClass t = new ThisClass("a");
        //ThisClass t1 = new ThisClass();
        System.out.println(UUID.randomUUID().toString().replaceAll("-" , ""));
    }
}
