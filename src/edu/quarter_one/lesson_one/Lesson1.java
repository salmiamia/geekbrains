package edu.quarter_one.lesson_one;

public class Lesson1 {

    public static void main(String[] args) {
        System.out.println(taskOne(4,5,8,3));
        System.out.println(taskTwo(7, 14));

    }

    //Task 1
    public static float taskOne(int a, int b, int c, int d) {
        return (a * (b + ((float)c / d)));
    }

    //Task 2
    public static boolean taskTwo(int a, int b){
        int sum = a + b;
        return sum >= 10 & sum <= 20;
    }


}

