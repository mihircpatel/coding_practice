package com.learning.codingpractice;

import com.learning.samples.models.Department;
import com.learning.samples.models.Employee;

import java.util.HashSet;
import java.util.Set;

public class CollectionTests {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "E1", 100000, Department.IT);
        Employee e2 = new Employee(1, "E1", 100000, Department.IT);

        Set<Employee> employees = new HashSet<>();

        employees.add(e1);
        employees.add(e2);

        System.out.println(employees);

    }

}
