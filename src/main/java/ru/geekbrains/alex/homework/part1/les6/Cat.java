package ru.geekbrains.alex.homework.les6;

public class Cat extends Animal {
    private static final int MAXRUNDISTANCE = 200;
    public static int countOfCat = 0;
    private String msg;

    public Cat(String name) {
        super(name);
        countOfCat++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAXRUNDISTANCE) {
            msg = "Котейка по кличке \"" + name + "\" пробежал " + distance + "м.";
        } else {
            msg = "Котейке нужно пробежать " + distance +
                    "м. Mission impossible. Котейка по кличке \"" + name +
                    "\" не может пробежать больше " + MAXRUNDISTANCE + "м.";
        }
        Printer.print(msg);
    }

    @Override
    public void swim(int distance) {
        msg = "Котейке нужно проплыть " + distance +
                "м. Fatal error!!! Котейка по кличке \"" +
                name + "\" не умеет плавать.";
        Printer.print(msg);
    }
}
