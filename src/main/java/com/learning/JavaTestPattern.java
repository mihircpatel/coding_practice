package com.learning;

import com.learning.samples.models.Department;
import com.learning.samples.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class JavaTestPattern {
    public static void main(String[] args) {

        //Draw Pattern
        digitTrianglePattern();

        List<Employee> employees = JavaTestPattern.Util.createEmployeeList();

        //findHighestSalary(employees);
    }

    private static void digitTrianglePattern() {
        //pattern
        // 1
        // 121
        int n=5;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            for(int j=i-1; j>=1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static class Util {
        public static List<Employee> createEmployeeList(){
            List<Employee> employeeList = new ArrayList<>();

            employeeList.add(new Employee(101, "Manish", 8000, Department.HR));
            employeeList.add(new Employee(102, "anuj", 6000, Department.IT));
            employeeList.add(new Employee(103, "aarush", 7000, Department.PRODUCT_DEVELOPMENT));
            employeeList.add(new Employee(104, "Ankur", 7000, Department.IT));
            employeeList.add(new Employee(105, "Jatin", 5000, Department.IT));
            employeeList.add(new Employee(106, "Raj", 7000, Department.IT));

            return employeeList;
        }
    }
}
