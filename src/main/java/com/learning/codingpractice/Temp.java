package com.learning.codingpractice;

public class Temp {

    public static void main(String args[])
    {
        double a, b,c;
        a = 2.0/0;
        b = 0/6.0;
        c= 0/0.0;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //System.out.println(A.b(() -> true)); //compile error -> cause of lambda expression is just for interfaces only
    }
}
