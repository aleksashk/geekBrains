package ru.geekbrains.alex.homework.les4.task23;

import java.util.Random;
import java.util.Scanner;

public class Task3MainApp {
    public static int xPC; //координата X хода ИИ
    public static int yPC; //координата Y хода ИИ

    public static int numberOfTurn = 0;//текущее общее количество сделанных ходов в игре

    public static int SIZE = 5; //размер поля
    public static char DOT_X = 'X';
    public static char DOT_O = 'O';
    public static char DOT_EMPTY = '.';
    public static int DOT_TO_WIN = 4;
    public static char[][] map;

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            numberOfTurn++;
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
            numberOfTurn++;
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
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
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

    //проверка наличия выигрышной комбинации в главной диагонали
    public static boolean isMainDiag(char symb) {
        int counter = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (map[i][i] == symb) {
                counter++;
                if (counter == DOT_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    //проверка наличия выигрышной комбинации во второй диагонали
    public static boolean isSecondDiag(char symb) {
        int counter = 0;
        for (int i = 0; i < DOT_TO_WIN; i++) {
            if (map[i][SIZE - 1 - i] == symb) {
                counter++;
                if (counter == DOT_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    //проверка наличия выигрышной комбинации в горизонталях
    public static boolean isGorizont(char symb) {
        int counter;
        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    counter++;
                    if (counter == DOT_TO_WIN) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    //проверка наличия выигрышной комбинации в вертикалях
    public static boolean isVertical(char symb) {
        int counter;
        for (int i = 0; i < SIZE; i++) {
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    counter++;
                    if (counter == DOT_TO_WIN) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    //ход ИИ
    public static void pcTurn() {
        do {
            if (!markDiagonal() && !markHorizontal() && !markVertical()) {
                if (numberOfTurn > 14) {
                    findEmpty(); // поиск первой пустой клетки для хода ИИ
                } else {
                    xPC = random.nextInt(4);
                    yPC = random.nextInt(4);
                }
            }
        } while (!isCeilValid(xPC, yPC));
        System.out.println("Компьютер походил в точку " + (xPC + 1) + " " + (yPC + 1));
        map[xPC][yPC] = DOT_O;
    }

    private static void findEmpty() {
        if (map[2][2] == DOT_EMPTY) {
            xPC = 2;
            yPC = 2;
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        xPC = i;
                        yPC = j;
                        return;
                    }
                }
            }
        }
    }

    //логика блокировки хода человека, если в вертикали есть
    //потенциально-выигрышная комбинация из 2 фишек и пустое поле
    public static boolean markVertical() {
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == DOT_X) {
                    if (i == 0 && map[i + 1][j] == DOT_X && map[i + 2][j] == DOT_EMPTY) {
                        xPC = i + 2;
                        yPC = j;
                        return true;
                    } else if (i == SIZE - 1 && map[i - 1][j] == DOT_X && map[i - 2][j] == DOT_EMPTY) {
                        xPC = i - 2;
                        yPC = j;
                        return true;
                    } else if (i > 0 && i < SIZE - 2 && map[i + 1][j] == DOT_X && (map[i + 2][j] == DOT_EMPTY || map[i - 1][j] == DOT_EMPTY)) {
                        if (map[i + 2][j] == DOT_EMPTY) {
                            xPC = i + 2;
                            yPC = j;
                            return true;
                        } else if (map[i - 1][j] == DOT_EMPTY) {
                            xPC = i - 1;
                            yPC = j;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //логика блокировки хода человека, если в горизонтали есть
    //потенциально-выигрышная комбинация из 2 фишек и пустое поле
    private static boolean markHorizontal() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    if (j == 0 && map[i][j + 1] == DOT_X && map[i][j + 2] == DOT_EMPTY) {
                        xPC = i;
                        yPC = j + 2;
                        return true;
                    } else if (j == SIZE - 1 && map[i][j - 1] == DOT_X && map[i][j - 2] == DOT_EMPTY) {
                        xPC = i;
                        yPC = j - 2;
                        return true;
                    } else if (j > 0 && j < SIZE - 2 && map[i][j + 1] == DOT_X && (map[i][j + 2] == DOT_EMPTY || map[i][j - 1] == DOT_EMPTY)) {
                        if (map[i][j + 2] == DOT_EMPTY) {
                            xPC = i;
                            yPC = j + 2;
                            return true;
                        } else if (map[i][j - 1] == DOT_EMPTY) {
                            xPC = i;
                            yPC = j - 1;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //логика блокировки хода человека, если в диагоналях есть
    //потенциально-выигрышная комбинация из 2 фишек и пустое поле
    public static boolean markDiagonal() {
        for (int i = 0, j = SIZE - 1 - i; i < SIZE; i++, j--) {
            if (map[i][i] == DOT_X) {
                if (i == 0 && map[i + 1][i + 1] == DOT_X && map[i + 2][i + 2] == DOT_EMPTY) {
                    xPC = i + 2;
                    yPC = i + 2;
                    return true;
                } else if (i == (SIZE - 1) && map[i - 1][i - 1] == DOT_X && map[i - 2][i - 2] == DOT_EMPTY) {
                    xPC = i - 2;
                    yPC = i - 2;
                    return true;
                } else if (i > 0 && i < (SIZE - 2) && map[i + 1][i + 1] == DOT_X && (map[i + 2][i + 2] == DOT_EMPTY || map[i - 1][i - 1] == DOT_EMPTY)) {
                    if (map[i + 2][i + 2] == DOT_EMPTY) {
                        xPC = i + 2;
                        yPC = i + 2;
                    } else if (map[i - 1][i - 1] == DOT_EMPTY) {
                        xPC = i - 1;
                        yPC = i - 1;
                    }
                    return true;
                } else if (i == (SIZE - 2) && map[i - 1][i - 1] == DOT_X && map[i - 2][i - 2] == DOT_EMPTY) {
                    xPC = i - 2;
                    yPC = i - 2;
                    return true;
                }
            } else if (map[i][j] == DOT_X) {
                if (i == 0 && map[i + 1][j - 1] == DOT_X && map[i + 2][j - 2] == DOT_EMPTY) {
                    xPC = i + 2;
                    yPC = j - 2;
                    return true;
                } else if (i == (SIZE - 1) && map[i - 1][j + 1] == DOT_X && map[i - 2][j + 2] == DOT_EMPTY) {
                    xPC = i - 2;
                    yPC = j + 2;
                    return true;
                } else if (i > 0 && i < (SIZE - 2) && map[i + 1][j - 1] == DOT_X && map[i + 2][j - 2] == DOT_EMPTY) {
                    xPC = i + 2;
                    yPC = j - 2;
                    return true;
                } else if (i == (SIZE - 2) && map[i - 1][j + 1] == DOT_X && map[i - 2][j + 2] == DOT_EMPTY) {
                    xPC = i - 2;
                    yPC = j + 2;
                    return true;
                }
            }
        }
        return false;
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Сделайте ход, введите координаты в формате X Y:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCeilValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCeilValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
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
