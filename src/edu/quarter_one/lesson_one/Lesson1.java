package edu.quarter_one.lesson_one;

public class Lesson1 {

    public static void main(String[] args) {
        System.out.println(taskOne(4,5,8,3));
        System.out.println(taskTwo(7, 14));
        System.out.println(taskThree(17));
        System.out.println(taskFour("Вася"));
        System.out.println(taskFive();
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

    //Task 5
    public static String taskFive(int a) {
        float a1 = a / 4f;
        int a2 = a / 4;
        float b1 = a / 100f;
        int b2 = a / 100;
        float c1 = a / 400f;
        int c2 = a / 400;


        if (a1 == a2 & b1 != b2 & c1 == c2){
            //високосный
        }
        return a + " год является високосным";
    }

}

