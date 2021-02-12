package ru.geekbrains.alex.homework.part2.les1;

public class MainApp {
    public static void main(String[] args){
        ObstacleCourse course1 = new ObstacleCourse(new Distance(1000), new Wall(2));
        ObstacleCourse course2 = new ObstacleCourse(new Distance(200), new Wall(1));
        ObstacleCourse course3 = new ObstacleCourse(new Distance(10000), new Wall(4));
        ObstacleCourse course4 = new ObstacleCourse(new Distance(100000), new Wall(8));

        ObstacleCourse[] courses = new ObstacleCourse[4];
        courses[0] = course1;
        courses[1] = course2;
        courses[2] = course3;
        courses[3] = course4;

        IAction[] actions = new IAction[3];
        actions[0] = new Cat("Vasily");
        actions[1] = new People("Kate");
        actions[2] = new Robot("3PR-14");

        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < courses.length; j++) {
                try {
                    actions[i].run(courses[j]);
                    actions[i].jump(courses[j]);
                } catch (TooLongDistanceException | TooHeightException e) {
                    System.out.println(e.getMessage());
                }
                actions[i].showVictoryStatus(courses[j]);
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
}
