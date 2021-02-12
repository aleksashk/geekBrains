package ru.geekbrains.alex.homework.part2.les1;

public interface IAction {
    void run(ObstacleCourse course) throws TooLongDistanceException;

    void jump(ObstacleCourse course) throws TooHeightException;

    void showVictoryStatus(ObstacleCourse course);
}
