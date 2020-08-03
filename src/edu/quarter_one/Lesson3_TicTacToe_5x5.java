package edu.quarter_one;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_TicTacToe_5x5 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int numToWin;
    private static char[][] field;

    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        numToWin = 4;
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
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
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
        int br;
        int cell;
        for (int x = 0; x < fieldSizeX; x++) {
            counter = 0;
            br = 0;
            cell = 1;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) counter++;
                if (field[x][y] != c && (fieldSizeX - numToWin) < cell) br = 1;
                if ((counter == numToWin || counter == fieldSizeX) && br == 0) return true;
                cell++;
            }
        }

        for (int y = 0; y < fieldSizeY; y++) {
            counter = 0;
            br = 0;
            cell = 1;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == c) counter++;
                if (field[x][y] != c && (fieldSizeX - numToWin) < cell) br = 1;
                if ((counter == numToWin || counter == fieldSizeY) && br == 0) return true;
                cell++;
            }
        }

        // ниже не доработан
        counter = 0;
        for (int x=0; x < fieldSizeX; x++) {
            for (int y = fieldSizeY-1-x; y >= 0; y--) {
                if (field[x][y] == c) counter++;
            }
            if (counter == numToWin) return true;
        }

        counter = 0;
        for (int x=0; x < fieldSizeX; x++) {
            if (field[x][x] == c) counter++;
            if (counter == numToWin) return true;
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