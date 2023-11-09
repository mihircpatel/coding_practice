package com.learning.interview.sas;

import com.learning.samples.models.Employee;

import java.util.Comparator;
import java.util.TreeMap;

public class FindStudentWithMaxMarks {

    void findStudentWithMaxMarks() {
        String[][] tc1 = { { "John", "87" },
                { "David", "100" },
                { "Cathy", "64" },
                { " David ", "22" } };


        for(int i=0; i< tc1[0].length; i++){

        }

        TreeMap<Employee, Integer> map = new TreeMap<>(Comparator.comparing(Employee::getName));
    }
}
