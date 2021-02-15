package ru.geekbrains.alex.homework.part2.les1;

public class Robot implements IAction {

    private String name;
    private int maxJumpHeight;
    private int maxDistanceLength;

    public Robot(String name, int maxJumpHeight, int maxDistanceLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxDistanceLength = maxDistanceLength;
    }

    public String info() {
        return name;
    }

    @Override
    public int run() {
        System.out.println("робот с названием \'" + name + "\' бежит.");
        return maxDistanceLength;
    }

    @Override
    public int jump() {
        System.out.println("робот с названием \'" + name + "\' прыгает.");
        return maxJumpHeight;
    }
}
