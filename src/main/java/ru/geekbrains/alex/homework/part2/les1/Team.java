package ru.geekbrains.alex.homework.part2.les1;

public class Team {
    private String name;
    private IAction[] team;

    public Team(String name, IAction[] team) {
        this.name = name;
        this.team = team;
    }

    public IAction[] getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
