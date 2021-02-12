package ru.geekbrains.alex.homework.part2.les1.task1;

import static ru.geekbrains.alex.homework.part2.les1.task1.Printer.print;

public class Cat implements Movable, Jumpable{
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void jump() {
        print("Cat \'" + name + "\' is jumping");
    }

    @Override
    public void move() {
        print("Cat \'" + name + "\' is running");
    }
}
