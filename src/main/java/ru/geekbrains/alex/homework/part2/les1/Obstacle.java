package ru.geekbrains.alex.homework.part2.les1;

public class Obstacle {
    private String name;
    private Distance distance;
    private Wall wall;

    public Obstacle(String name, Distance distance, Wall wall) {
        this.name = name;
        this.distance = distance;
        this.wall = wall;
    }

    public Distance getDistance() {
        return distance;
    }

    public Wall getWall() {
        return wall;
    }

    public String getName() {
        return name;
    }

    public boolean overcome(ICourse member) {
        return getWall().overcome(member) && getDistance().overcome(member);
    }
}
