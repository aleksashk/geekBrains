package ru.geekbrains.alex.homework.part2.les1;

public class People implements IAction {
    public static final int MAX_JUMP_HEIGHT = 1;
    public static final int MAX_RUN_LENGTH = 50000;

    private String name;
    private boolean flagRun;
    private boolean flagJump;

    public People(String name) {
        this.name = name;
        flagRun = false;
        flagJump = false;
    }

    @Override
    public void run(ObstacleCourse course) throws TooLongDistanceException {
        if (course.getDistance().getLength() > MAX_RUN_LENGTH) {
            String msg = "Расстояние в " +
                    course.getDistance().getLength() +
                    "м. слишком большое для человека!!!\nЧеловек " +
                    name +
                    " не смог пробежать дистанцию, он же не робот.";
            flagRun = false;
            throw new TooLongDistanceException(msg);
        } else {
            flagRun = true;
            System.out.println("Человек " + name + " смог пробежать расстояние в " + course.getDistance().getLength() + "м.");
        }
    }

    @Override
    public void jump(ObstacleCourse course) throws TooHeightException {
        if (course.getWall().getHeight() > MAX_JUMP_HEIGHT) {
            String msg = "Стена высотой " +
                    course.getWall().getHeight() +
                    "м. - это слишком высокая приграда для человека!!!\nЧеловек " +
                    name +
                    " не смог перепрыгнуть стену. Он же не робот!!!";
            flagJump = false;
            throw new TooHeightException(msg);
        } else {
            flagJump = true;
            System.out.println("Человек " + name + " смог перепрыгнуть стену высотой " + course.getWall().getHeight() + "м.");
        }
    }

    @Override
    public void showVictoryStatus(ObstacleCourse course) {
        System.out.print("ИТОГИ ТУРНИРА:\n");
        if (flagJump && flagRun) {
            System.out.println("\tЧеловек " + name + " смог приодолеть полосу препятствий:" + course.toString());
        } else {
            System.out.println("\tЧеловек " + name + " НЕ смог приодолеть полосу препятствий:" + course.toString());
        }
    }
}
