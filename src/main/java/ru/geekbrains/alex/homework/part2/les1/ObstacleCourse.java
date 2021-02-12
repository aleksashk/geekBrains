package ru.geekbrains.alex.homework.part2.les1;

public class ObstacleCourse {
    private Distance distance;
    private Wall wall;

    public ObstacleCourse(Distance distance, Wall wall) {
        this.distance = distance;
        this.wall = wall;
    }

    public Wall getWall() {
        return wall;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "\n\t[длина беговой дорожки = " + distance.getLength() +
                "м, высота стены = " + wall.getHeight() +
                "м]";
    }
}
