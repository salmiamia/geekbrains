package edu.quarter_one.lesson4;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov Ivan", 200000, 28);
        System.out.println("4 задание:");
        System.out.println("name: " + employee1.getFullName() + ", age: " + employee1.getAge());
        System.out.println("");

        Employee[] listOfEmployees = new Employee[5];
        listOfEmployees[0] = new Employee("Ivanov Ivan", 45000.00, 28);
        listOfEmployees[1] = new Employee("Petrov Nikolay", 120000.00, 30);
        listOfEmployees[2] = new Employee("Smirnov Andrey", 150000.00, 47);
        listOfEmployees[3] = new Employee("Kuznetsov Alexander", 220000.00, 51);
        listOfEmployees[4] = new Employee("Ermakov Pavel", 360000.00, 40);

        // задание 5, вывести список сотрудников старше 40 лет
        System.out.println("5 задание. Сотрудники старше 40 лет:");
        for (int i = 0; i < listOfEmployees.length; i++) {
            if (listOfEmployees[i].getAge() > 40) {
                System.out.println(listOfEmployees[i].getFullName() + ", salary: " + listOfEmployees[i].getSalary() + ", age: " + listOfEmployees[i].getAge());
            }
        }
        System.out.println("");

        // задание 6, повышение зарплаты на 5000 для сотрудников старше 45 лет
        double totalSalariesBeforeRaising = 0;
        for (int i = 0; i < listOfEmployees.length; i++) {
            totalSalariesBeforeRaising = totalSalariesBeforeRaising + listOfEmployees[i].getSalary();
            if (listOfEmployees[i].getAge() > 45) {
                listOfEmployees[i].setSalary(listOfEmployees[i].getSalary() + 5000);
            }
        }
        System.out.println("6 задание. Зарплата следующих сотрудников была увеличена на 5000:");
        for (int i = 0; i < listOfEmployees.length; i++) {
            if (listOfEmployees[i].getAge() > 40) {
                System.out.println(listOfEmployees[i].getFullName() + ", salary: " + listOfEmployees[i].getSalary());
            }
        }
        System.out.println("");

        //задание 7, средняя зарплата до и после повышения
        double averageSalariesBeforeRaising = totalSalariesBeforeRaising / listOfEmployees.length;
        int totalAge = 0;
        double totalSalariesAfterRaising = 0;
        for (int i = 0; i < listOfEmployees.length; i++) {
            totalSalariesAfterRaising = totalSalariesAfterRaising + listOfEmployees[i].getSalary();
            totalAge = totalAge + listOfEmployees[i].getAge();
        }
        double averageSalariesAfterRaising = totalSalariesAfterRaising / listOfEmployees.length;
        int averageAge = totalAge / listOfEmployees.length;

        System.out.println("7 задание.");
        System.out.println("Средняя зарплата до повышения: " + averageSalariesBeforeRaising);
        System.out.println("Средняя зарплата после повышения: " + averageSalariesAfterRaising);
        System.out.println("Средний возраст сотрудников: " + averageAge);
        System.out.println("");

        //8 задание, присвоение личного ID сотрудникам
        System.out.println("8 задание.");
        for (int i = 0; i < listOfEmployees.length; i++) {
            System.out.println("#" + listOfEmployees[i].getId() + " " + listOfEmployees[i].getFullName());
        }
    }
    
}
