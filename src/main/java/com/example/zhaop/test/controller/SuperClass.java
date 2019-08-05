package com.example.zhaop.test.controller;

public class SuperClass {

    public int age = 2;

    public SuperClass(){
        System.out.println("22222222222222222222");
    }
}

class SuperClassChild extends SuperClass{

    public SuperClassChild () {
        int i = super.age;
        System.out.println("11111111111111111111");
        //super.SuperClassa();
    }

    public void run() {
        System.out.println(super.age);
    }

    public static void main(String[] args) {
        SuperClassChild s = new SuperClassChild();
        //s.run();

    }

}




