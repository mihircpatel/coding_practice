package com.learning.samples;

public interface DefaultInterface {

    default void show(){
        System.out.println("From Default Interface Method");
    }
}
