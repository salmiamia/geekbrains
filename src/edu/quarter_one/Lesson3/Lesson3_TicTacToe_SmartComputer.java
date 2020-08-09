package edu.quarter_one.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_TicTacToe_SmartComputer {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода по X и Y (от 1 до 3) через пробел>>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {

        // проверка по горизонтали
        int counter1;
        int f1 = 0;
        for (int xx = 0; xx < fieldSizeX; xx++) {
            counter1 = 0;
            for (int yy = 0; yy < fieldSizeY; yy++) {
                if (field[xx][yy] == DOT_HUMAN)
                {
                    counter1++;
                }
                if (counter1 == (fieldSizeX - 1)) {
                    for (int yyy = 0; yyy < fieldSizeY; yyy++) {
                        if (field[xx][yyy] == DOT_EMPTY)
                        {
                            field[xx][yyy] = DOT_AI;
                            f1 = 1;
                        }
                    }
                }
            }
        }

        // проверка по вертиткали
        int counter2;
        int f2 = 0;
        for (int yy = 0; yy < fieldSizeX; yy++) {
            counter2 = 0;
            for (int xx = 0; xx < fieldSizeY; xx++) {
                if (field[xx][yy] == DOT_HUMAN)
                {
                    counter2++;
                }
                if (counter2 == (fieldSizeX - 1)) {
                    for (int xxx = 0; xxx < fieldSizeY; xxx++) {
                        if (field[xxx][yy] == DOT_EMPTY)
                        {
                            field[xxx][yy] = DOT_AI;
                            f2 = 1;
                        }
                    }
                }
            }
        }

        // проверка по диагонали1
        int counter3 = 0;
        int f3 = 0;
        int x_new = 0;
        int y_new = 0;
        for (int xx = 0; xx < fieldSizeX; xx++) {
            for (int yy = fieldSizeY-1-xx; yy >= 0; yy--) {
                if (field[xx][yy] == DOT_HUMAN)
                {
                    counter3++;
                }
                if (field[xx][yy] == DOT_EMPTY)
                {
                    x_new = xx;
                    y_new = yy;
                }
                if (counter3 == (fieldSizeX - 1)) {
                    f3 = 1;
                    field[x_new][y_new] = DOT_AI;
                }
            }
        }

        if (f1 == 0 && f2 == 0 && f3 == 0) {
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));
            field[y][x] = DOT_AI;
        }


    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {

        int counter;
        for (int x = 0; x < fieldSizeX; x++) {
            counter = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) counter++;
            }
            if (counter == fieldSizeX) return true;
        }

        for (int y = 0; y < fieldSizeY; y++) {
            counter = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == c) counter++;
            }
            if (counter == fieldSizeY) return true;
        }

        // не доработано
        counter = 0;
        for (int x=0; x < fieldSizeX; x++) {
            for (int y = fieldSizeY-1-x; y >= 0; y--) {
                if (field[x][y] == c) counter++;
            }
            if (counter == fieldSizeY) return true;
        }

        counter = 0;
        for (int x=0; x < fieldSizeX; x++) {
            if (field[x][x] == c) counter++;
            if (counter == fieldSizeY) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();
        String answer;
        do {
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}