package com.learning.codingpractice;

class ThreadClass extends Thread {
    public ThreadClass() {
        System.out.println("Constructor...");
    }

    public void run(String s) {
        System.out.println("Run with argument..");
    }

    public void run(){
        System.out.println("Run..");
    }
}
public class ThreadTest {
    public static void main(String[] args) {

        Thread t = new ThreadClass(){
            public void run(){
                System.out.println("Overridden run");
            }
        };

        t.start();
    }
}
