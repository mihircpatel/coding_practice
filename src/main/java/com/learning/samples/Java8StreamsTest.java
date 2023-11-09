package com.learning.samples;

import com.learning.samples.models.Department;
import com.learning.samples.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8StreamsTest {
    public static void main(String[] args) {
        List<Employee> employees = Util.createEmployeeList();

        getEmployeeByGroup(employees);
        getEmployeeByGroupMultiple(employees);
        getEmployeeAvgSalaryByDepartment(employees);
        getEmployeeNameByCriteria(employees, employee -> employee.getSalary() > 6000);
        getEmployeeMapByIdAndName(employees);
        getEmployeeWithNthHighestSalary(employees, 3);
        //getEmployeeTemp(employees, 3);

        System.out.println("Max Value: " + ArrayStreamTest.getMax(new long[]{2, 1, 9, 5, 6}));
    }

    private static void getEmployeeByGroup(List<? extends Employee> employees) {
        Map<Department, List<Employee>> groupedByDeptEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Group By Department: " + groupedByDeptEmployee);
    }

    private static void getEmployeeByGroupMultiple(List<? extends Employee> employees) {
        Map<Department, Map<Long, List<Employee>>> groupedByDeptEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getSalary)));
        System.out.println("Group By Department and salary: " + groupedByDeptEmployee);
    }

    private static void getEmployeeAvgSalaryByDepartment(List<? extends Employee> employees) {
        Map<Department, Double> groupedByDeptEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
        System.out.println("Average Salary by Department: " + groupedByDeptEmployee);
    }

    private static void getEmployeeNameByCriteria(List<? extends Employee> employees, Predicate<Employee> criteria) {
        List<String> employeesByCriteria = employees.stream()
                .filter(criteria)
                .map(em -> em.getName())
                .collect(Collectors.toList());
        System.out.println("Employees having Salary greater than 6000: " + employeesByCriteria);
    }

    private static void getEmployeeMapByIdAndName(List<Employee> employees) {
        Map<Integer, String> employeesByIdAndName = employees.stream()
                .collect(Collectors.toMap(em -> em.getId(), em -> em.getName()));
        System.out.println("Employees map by ID and Name: " + employeesByIdAndName);
    }

    private static void getEmployeeWithNthHighestSalary(List<Employee> employees, int n) {
        Employee employee = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .limit(n)
                .peek(e -> System.out.println("Employee -> " + e))
                .skip(n-1)
                .findFirst()
                .get();
        System.out.println("Employees with nth [" + n + "] highest Salary (With Duplicate): " + employee);
    }

    private static void getEmployeeTemp(List<Employee> employees, int n) {
        employees = null;
        List<Employee> employee = employees.stream()
        //Employee employee = employees.stream()
                //.filter(e -> Collections.frequency(employees, e) == 1)
                .collect(Collectors.toList());
        System.out.println("Employees with nth [" + n + "] highest Salary: " + employee);
    }

    static class ArrayStreamTest {
        public static long getMax(long[] numbers) {
            return Arrays.stream(numbers).max().getAsLong();
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

