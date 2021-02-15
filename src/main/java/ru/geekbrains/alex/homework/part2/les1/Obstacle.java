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

    public String getName() {
        return name;
    }

    public boolean overcome(IAction member) {
        return wall.overcome(member) && distance.overcome(member);
    }
}
