package edu.quarter_one;

public class Lesson2 {

    public static void main(String[] args) {
        PrintArrayLine(taskOne(myArray1));
        PrintArrayLine(taskTwo(myArray2));
        PrintArrayLine(taskThree(myArray3));
        PrintArrayLine(taskFour(myArray4));
        PrintArraySquare(taskFive(myArray5));
        System.out.println(taskSix(myArray6));
    }

    // Task 1
    // Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    public static int[] myArray1 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    public static int[] taskOne(int[] anyArray) {
        for (int i = 0; i < 10; i++) {
            if (anyArray[i] == 1) {
                anyArray[i] = 0;
            } else {
                anyArray[i] = 1;
            }
        }
        return anyArray;
    }

    // Task 2
    // Задать пустой целочисленный массив размером 8.
    // Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    public static int[] myArray2 = new int[8];
    public static int[] taskTwo(int[] q) {

        int n = 1;

        for (int i = 0; i <= 7; i++) {
            q[i] = n;
            n += 3;
        }
        return q;
    }

    // Task 3
    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    // написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    public static int[] myArray3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    public static int[] taskThree(int[] d) {
        for (int i = 0; i < d.length; i++) {
            if(d[i] < 6) {
                d[i] = d[i] * 2;
            }
        }
        return d;
    }

    // Task 4
    // Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    public static int[] myArray4 = new int[] {7, 5, 23, 2, 11, 4, -4, 2, 4, -18, 9, 1};
    public static int[] MinMaxNumbers = new int[2];
    public static int min, max;
    public static int[] taskFour(int[] b) {

        min = b[0];
        max = b[0];

       for (int i = 0; i < b.length; i++) {
                if (b[i] < min) min = b[i];
                if (b[i] > max) max = b[i];
        }
        MinMaxNumbers[0] = min;
        MinMaxNumbers[1] = max;

        return MinMaxNumbers;
    }

    // Task 5
    // Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    // заполнить его диагональные элементы единицами, используя цикл(ы);
    public static int[][] myArray5 = new int[17][17];
    public static int[][] taskFive(int[][] e) {
        for (int x=0; x < e.length; x++) {
            e[x][x] = 1;
            for (int y = e.length-1-x; y >= 0; y--) {
                e[y][x] = 1;
                break;
            }
        }
        return e;
    }

    // Task 6
    // Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой
    // части массива равны. Примеры: checkBalance([1, 1, 1, 2, 1]) → true,
    // checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true.
    public static int[] myArray6 = new int[] {1, 5, 3, 4, 3, 1, 6, 2, 7};
    public static int sum;
    public static int halfSum;
    public static boolean taskSix(int[] d) {

        for (int i = 0; i < d.length; i++) {
            sum = sum + d[i];
        }
        if (sum % 2 != 0) return false;

        for (int i = 0; i < d.length; i++) {
            halfSum = halfSum + d[i];
            if (halfSum == sum / 2) return true;
        }
        return false;
    }


    // Вывод в консоль
    public static void PrintArrayLine(int[] w) {
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i]);
        }
    }

    public static void PrintArraySquare(int[][] z) {
        for (int x = 0; x < z.length; x++) {
            for (int y = 0; y < z.length; y++) {
                System.out.printf("%4d", z[x][y]);
            }
            System.out.println("");
        }
    }
}
