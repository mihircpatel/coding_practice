package com.learning.codingpractice;

public abstract class A {
    abstract boolean a();
    static boolean b(A a) {
        return a.a();
    }
}

