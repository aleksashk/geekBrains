package ru.geekbrains.alex.homework.part2.les1;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void dolt(Team team) {
        for (IAction member : team.getTeam()) {
            for (Obstacle o : obstacles) {
                if (!o.overcome(member)){
                    System.out.println(member.getClass().getSimpleName() + " \'" + member.info() + "\' из команды \'" + team.getName().toUpperCase() + "\' не прошёл полосу препятствий \'" + o.getName() + "\' и сошёл с дистанции.");
                    break;
                }else {
                    System.out.println(member.getClass().getSimpleName() + " " + member.info() + " из команды \'" + team.getName().toUpperCase() + "\' прошёл полосу препятствий \'" + o.getName() + "\'.");
                }
            }
            System.out.println("----------------------------------------------");
        }
    }
}
