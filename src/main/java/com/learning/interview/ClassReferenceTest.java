package com.learning.interview;

public class ClassReferenceTest {
    public static void main(String[] args) {
        Student student = new Student("S1");
        System.out.println(student.getName());
        update(student);
        System.out.println(student.getName());

    }

    static void update(Student stud){
        stud = new Student("S2");
    }
}
