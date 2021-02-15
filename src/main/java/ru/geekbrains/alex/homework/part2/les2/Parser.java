package ru.geekbrains.alex.homework.part2.les2;

public class Parser {
    public static void checkTypeArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер матрицы не соответствует условию");
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Размер матрицы не соответствует условию");
            }
        }
    }

    public static int getSum(String[][] s) throws MyArrayDataException, MyArraySizeException {
        checkTypeArray(s);
        int result = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                try {
                    result += Integer.parseInt(s[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("элемент матрицы с индексами [" + i + "][" + j + "] = \"" + s[i][j] + "\" не может быть преобразован к типу int!!!");
                }
            }
        }
        return result;
    }
}
