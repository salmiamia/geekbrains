package edu.quarter_one.lesson_one;

public class Lesson1 {

    public static void main(String[] args) {
        System.out.println(taskOne(4,5,8,3));
        System.out.println(taskTwo(7, 14));
        System.out.println(taskThree(0));
        System.out.println(taskFour("Вася"));
    }

    //Task 1
    public static float taskOne(int a, int b, int c, int d) {
        return (a * (b + ((float)c / d)));
    }

    //Task 2
    public static boolean taskTwo(int a, int b) {
        int sum = a + b;
        return sum >= 10 & sum <= 20;
    }

    //Task 3
    public static String taskThree(int a) {
        if (a >= 0) return (a + " is positive number");
        else return (a + " is negative number");
    }

    //Task 4
    public static String taskFour(String a) {
        return "Привет, " + a + "!";
    }


    //*Написать метод, который определяет является ли год високосным.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    // Для проверки работы вывести результаты работы метода в консоль.

}

