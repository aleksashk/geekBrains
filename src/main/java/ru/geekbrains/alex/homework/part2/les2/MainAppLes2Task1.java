package ru.geekbrains.alex.homework.part2.les2;

import static ru.geekbrains.alex.homework.part2.les2.Printer.print;

public class MainAppLes2Task1 {
    public static void main(String[] args) {
        String[][] matrix1 = {
                {"45", "587", "0", "784"},
                {"-12", "1000254", "0", "-5241170"},
                {"34455", "-5014", "587446", "596688"},
                {"32", "-7524", "1004", "-87411"}};

        String[][] matrix2 = {
                {"=45", "0D587", "0", "784"},
                {"-12", "fgRRR254", "0", "-5241170"},
                {"34455", "-5014", "5TGffc6", "596688"},
                {"32", "-7524", "---", "4gg1"}};

        String[][] matrix3 = {
                {"=45", "0D587", "0", "784"},
                {"-12", "fgRRR254", "-5241170"},
                {"34455", "-5014", "5TGffc6", "596688"},
                {"32", "-7524", "---", "tttt-", "4gg1"}};

        sumator(matrix1);
        sumator(matrix2);
        sumator(matrix3);
    }

    public static void sumator(String[][] s) {
        try {
            print("сумма элементов матрицы: " + Parser.getSum(s));
        } catch (MyArrayDataException | MyArraySizeException e) {
            print(e.getMessage());
        }
    }
}
