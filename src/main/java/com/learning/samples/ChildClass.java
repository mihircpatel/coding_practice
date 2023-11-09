package com.learning.samples;

public class ChildClass extends ParentClass implements DefaultInterface{

    @Override
    public void show() {
        DefaultInterface.super.show();
    }

    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();

        childClass.show();
    }
}

