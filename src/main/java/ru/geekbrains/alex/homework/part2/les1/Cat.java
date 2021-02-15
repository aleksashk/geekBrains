package ru.geekbrains.alex.homework.part2.les1;

public class Cat implements IAction {

    private String name;
    private int maxJumpHeight;
    private int maxDistanceLength;

    public Cat(String name, int maxJumpHeight, int maxDistanceLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxDistanceLength = maxDistanceLength;
    }

    @Override
    public int run() {
        System.out.println("кот \'" + name + "\' бежит.");
        return maxDistanceLength;
    }

    @Override
    public int jump() {
        System.out.println("кот \'" + name + "\' прыгает.");
        return maxJumpHeight;
    }

    @Override
    public String info() {
        return name;
    }
}
