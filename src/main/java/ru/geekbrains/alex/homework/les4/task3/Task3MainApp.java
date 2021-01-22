package ru.geekbrains.alex.homework.les4.task3;

import java.util.Random;
import java.util.Scanner;

public class Task3MainApp {
    public static char[][] map;
    public static final int SIZE = 5;

    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            pcTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил ИИ");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symb) {
        return isMainDiag(symb) ||
                isSecondDiag(symb) ||
                isGorizont(symb) ||
                isVertical(symb);
    }

    public static boolean isMainDiag(char symb) {
        int i = 0;
        int counter = 0;
        while (map[i][i] != symb && i < SIZE - 1) {
            i++;
        }
        for (int j = i; j < SIZE; j++) {
            if (map[j][j] == symb) {
                counter++;
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public static boolean isSecondDiag(char symb) {
        int i = 0;
        int counter = 0;
        while (map[i][SIZE - 1 - i] != symb && i < SIZE - 1) {
            i++;
        }
        for (int j = i; j < SIZE; j++) {
            if (map[j][SIZE - 1 - j] == symb) {
                counter++;
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public static boolean isGorizont(char symb) {

        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            int j = 0;
            while (map[i][j] != symb && j < SIZE - 1) {
                j++;
            }
            for (int k = j; k < SIZE; k++) {
                if (map[i][k] == symb) {
                    counter++;
                    if (counter == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public static boolean isVertical(char symb) {
        for (int j = 0; j < SIZE; j++) {
            int counter = 0;
            int i = 0;
            while (map[i][j] != symb && i < SIZE - 1) {
                i++;
            }
            for (int k = i; k < SIZE; k++) {
                if (map[k][j] == symb) {
                    counter++;
                    if (counter == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCeilValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void pcTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCeilValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isCeilValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
