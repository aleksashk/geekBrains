package ru.geekbrains.alex.homework.part2.les1;

public class Robot implements IAction {
    public static final int MAX_JUMP_HEIGHT = 10;
    public static final int MAX_RUN_LENGTH = 3000;

    private String name;
    private boolean flagRun;
    private boolean flagJump;

    public Robot(String name) {
        this.name = name;
        flagRun = false;
        flagJump = false;
    }

    @Override
    public void run(ObstacleCourse course) throws TooLongDistanceException {
        if (course.getDistance().getLength() > MAX_RUN_LENGTH) {
            String msg = "Расстояние в " +
                    course.getDistance().getLength() +
                    "м слишком большое для робота!!!\nРобот " +
                    name +
                    " не смог пробежать дистанцию.";
            flagRun = false;
            throw new TooLongDistanceException(msg);
        } else {
            flagRun = true;
            System.out.println("Робот " + name + " смог пробежать расстояние в " + course.getDistance().getLength() + "м.");
        }
    }

    @Override
    public void jump(ObstacleCourse course) throws TooHeightException {
        if (course.getWall().getHeight() > MAX_JUMP_HEIGHT) {
            String msg = "Стена высотой " +
                    course.getDistance().getLength() + "м. Робот" +
                    name +
                    " не смог перепрыгнуть стену.";
            flagJump = false;
            throw new TooHeightException(msg);
        } else {
            flagJump = true;
            System.out.println("Робот " + name + " смог перепрыгнуть стену высотой " + course.getWall().getHeight() + "м.");
        }
    }

    @Override
    public void showVictoryStatus(ObstacleCourse course) {
        System.out.print("ИТОГИ ТУРНИРА:\n");
        if (flagJump && flagRun) {
            System.out.println("\tРобот " + name + " смог приодолеть полосу препятствий:" + course.toString());
        } else {
            System.out.println("\tРобот " + name + " НЕ смог приодолеть полосу препятствий:" + course.toString());
        }
    }
}
