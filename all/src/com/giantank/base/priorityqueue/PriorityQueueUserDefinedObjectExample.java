package com.giantank.base.priorityqueue;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueUserDefinedObjectExample {
    public static void main(String[] args) {
        PriorityQueue<Employee> employees = new PriorityQueue<>();
        employees.add(new Employee("Rajeev", 19, 100000.00));
        employees.add(new Employee("Andrea", 16, 115000.00));
        employees.add(new Employee("Chris", 20, 145000.00));
        employees.add(new Employee("Jackson", 13, 187000.00));
        employees.add(new Employee("Jack", 13, 167000.00));

        while (!employees.isEmpty()) {
            //System.out.println(employees.remove());
            Employee em = employees.poll();
            System.out.println(em.getName() + ":" + em.getAge() + ":" + em.getSalary());
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.age != employee.age) {
            return this.age - employee.age;
        } else {
            return Double.compare(this.salary, employee.salary);
        }
    }
}
