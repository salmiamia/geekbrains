package edu.quarter_one.lesson4;


public class Employee {

    private String fullName;
    private double salary;
    private int age;
    private static int counter = 0;
    private final int id;

    Employee(String fullName, double salary, int age){
        this.fullName = fullName;
        this.salary = salary;
        this.age = age;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}