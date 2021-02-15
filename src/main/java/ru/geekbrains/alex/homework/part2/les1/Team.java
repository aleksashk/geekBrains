package ru.geekbrains.alex.homework.part2.les1;

public class Team {
    private String name;
    private ICourse[] team;

    public Team(String name, ICourse[] team) {
        this.name = name;
        this.team = team;
    }

    public ICourse[] getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
