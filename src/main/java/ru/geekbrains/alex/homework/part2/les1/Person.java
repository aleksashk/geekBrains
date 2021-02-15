package ru.geekbrains.alex.homework.part2.les1;

public class Person implements IAction {

    private String name;
    private int maxJumpHeight;
    private int maxDistanceLength;

    public Person(String name, int maxJumpHeight, int maxDistanceLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxDistanceLength = maxDistanceLength;
    }

    public String info() {
        return name;
    }

    @Override
    public int run() {
        System.out.println("человек по имени \'" + name + "\' бежит.");
        return maxDistanceLength;
    }

    @Override
    public int jump() {
        System.out.println("человек по имени \'" + name + "\' прыгает.");
        return maxJumpHeight;
    }
}
