package com.learning.interview;

import java.util.Date;

/**
 * Declare the class as final: By declaring a class final, you prevent other classes from extending it.
 *
 * Declare all the fields as final: Once the field is assigned a value, it cannot be changed.
 *
 * Don't provide any setter methods: Since the fields are final, they can only be set once, either through the
 * constructor or through initialization.
 *
 * Ensure that the methods don't modify the state of the object: All the methods in the class should be written in
 * such a way that they don't change the state of the object.
 *
 * Make a defensive copy of mutable objects: If the class has a field that is mutable, then you should make a
 * defensive copy of it in the constructor.
 */
public final class ImmutableClass {
    private final int value;
    private final String name;
    private final Date date;

    public ImmutableClass(int value, String name, Date date) {
        this.value = value;
        this.name = name;
        this.date = new Date(date.getTime()); // Make a defensive copy
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return new Date(date.getTime()); // Return a defensive copy
    }
}

