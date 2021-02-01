package ru.geekbrains.alex.homework.les6;

public class Dog extends Animal {
    private static final int MAXRUNDISTANCE = 500;
    private static final int MAXSWIMDISTANCE = 10;
    public static int countOfDog = 0;
    private String msg;

    public Dog(String name) {
        countOfDog++;
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAXRUNDISTANCE) {
            msg = "Собакен по кличке \"" + name + "\" пробежал " + distance + "м.";
        } else {
            msg = "Собакену нужно пробежать " + distance +
                    "м. Attention! Собакен по кличке \"" + name +
                    "\" не может пробежать больше " + MAXRUNDISTANCE + "м.";
        }
        Printer.print(msg);
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAXSWIMDISTANCE) {
            msg = "Собакен по кличке \"" + name +
                    "\" проплыл " + distance + "м.";
        } else {
            msg = "Собакену нужно проплыть " + distance +
                    "м. Warning!!! Собакен по кличке \"" + name +
                    "\" не может проплыть больше " + MAXSWIMDISTANCE + "м.";
        }
        Printer.print(msg);
    }
}
