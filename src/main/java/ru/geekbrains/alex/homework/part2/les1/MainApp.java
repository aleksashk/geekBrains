package ru.geekbrains.alex.homework.part2.les1;

public class MainApp {
    public static void main(String[] args) {
        IAction[] members1 = {
                new Cat("Laska", 5, 10000),
                new Person("Ivanka", 6, 50000),
                new Robot("3PR-16", 8, 13000),
                new Cat("John", 10, 7000)
        };

        IAction[] members2 = {
                new Cat("Bob", 1, 100),
                new Person("Flora", 1, 500),
                new Robot("745-UBSD-FR07", 2, 300),
                new Cat("BorIs", 1, 240)
        };

        Team team1 = new Team("faster", members1);
        Team team2 = new Team("looser", members2);

        Obstacle[] obstacles = new Obstacle[4];
        obstacles[0] = new Obstacle("Simple obstacle", new Distance(7000), new Wall(2));
        obstacles[1] = new Obstacle("Long obstacle", new Distance(1000), new Wall(5));
        obstacles[2] = new Obstacle("Hard obstacle", new Distance(5000), new Wall(4));
        obstacles[3] = new Obstacle("Easy obstacle", new Distance(2000), new Wall(4));

        Course c1 = new Course(obstacles);

        c1.dolt(team1);
        c1.dolt(team2);

    }
}
