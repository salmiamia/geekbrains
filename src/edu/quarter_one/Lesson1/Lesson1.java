package edu.quarter_one.Lesson1;

public class Lesson1 {

    public static void main(String[] args) {
        System.out.println(taskOne(4,5,8,3));
        System.out.println(taskTwo(3, 13));
        taskThree(3);
        taskFour("Иван");
        taskFive(2023);
    }

    // Task 1
    // Написать метод вычисляющий выражение a * (b + (c / d))
    // и возвращающий результат с плавающей точкой,
    // где a, b, c, d – целочисленные входные параметры этого метода.
    public static float taskOne(int a, int b, int c, int d) {
        return (a * (b + ((float)c / d)));
    }

    // Task 2
    // Написать метод, принимающий на вход два целых числа,
    // и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean taskTwo(int a, int b) {
        int sum = a + b;
        return sum >= 10 & sum <= 20;
    }

    // Task 3
    // Написать метод, которому в качестве параметра передается целое число,
    // метод должен проверить положительное ли число передали, или отрицательное.
    // Замечание: ноль считаем положительным числом.
    // Результат работы метода вывести в консоль.
    public static void taskThree(int a) {
        if (a >= 0) System.out.println (a + " is positive number");
        else System.out.println (a + " is negative number");
    }

    // Task 4
    // Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя, метод должен вернуть приветственное сообщение
    // «Привет, переданное_имя!» Вывести приветствие в консоль.
    public static void taskFour(String a) {
        System.out.println("Привет, " + a + "!");
    }
 
    // Task 5
    // *Написать метод, который определяет является ли год високосным.
    // Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.
    // Для проверки работы вывести результаты работы метода в консоль.
    public static void taskFive(int a) {
        float a1 = a / 4f;
        int a2 = a / 4;
        float b1 = a / 100f;
        int b2 = a / 100;
        float c1 = a / 400f;
        int c2 = a / 400;

        if (a <= 0) System.out.println("Год может быть только целым положительным числом. Попробуйте снова.");
        else if (c1 == c2) System.out.println(a + " год является високосным");
        else if (b1 == b2) System.out.println(a + " год не является високосным");
        else if (a1 == a2) System.out.println(a + " год является високосным");
        else System.out.println(a + " год не является високосным");
    }

}

