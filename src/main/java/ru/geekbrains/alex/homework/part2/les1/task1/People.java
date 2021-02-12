package ru.geekbrains.alex.homework.part2.les1.task1;

import static ru.geekbrains.alex.homework.part2.les1.task1.Printer.print;

public class People implements Movable, Jumpable{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void jump() {
        print("Person \'" + name + "\' is jumping");
    }

    @Override
    public void move() {
        print("Person \'" + name + "\' is running");
    }
}
