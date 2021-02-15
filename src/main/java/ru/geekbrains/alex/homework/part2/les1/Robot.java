package ru.geekbrains.alex.homework.part2.les1;

public class Robot implements ICourse {

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
        System.out.println("robot \'" + name + "\' is run.");
        return maxDistanceLength;
    }

    @Override
    public int jump() {
        System.out.println("robot \'" + name + "\' is jump.");
        return maxJumpHeight;
    }
}
