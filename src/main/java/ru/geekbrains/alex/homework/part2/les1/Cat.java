package ru.geekbrains.alex.homework.part2.les1;

public class Cat implements IAction {
    public static final int MAX_JUMP_HEIGHT = 2;
    public static final int MAX_RUN_LENGTH = 400;

    private String name;
    private boolean flagRun;
    private boolean flagJump;

    public Cat(String name) {
        this.name = name;
        flagRun = false;
        flagJump = false;
    }

    @Override
    public void run(ObstacleCourse course) throws TooLongDistanceException {
        if (course.getDistance().getLength() > MAX_RUN_LENGTH) {
            String msg = "Расстояние в " +
                    course.getDistance().getLength() +
                    "м. слишком большое для кота!!!\nКот " +
                    name +
                    " не смог пробежать дистанцию.";
            flagRun = false;
            throw new TooLongDistanceException(msg);
        } else {
            flagRun = true;
            System.out.println("Кот " + name + " смог пробежать расстояние в " + course.getDistance().getLength() + "м.");
        }
    }

    @Override
    public void jump(ObstacleCourse course) throws TooHeightException {
        if (course.getWall().getHeight() > MAX_JUMP_HEIGHT) {
            flagJump = false;
            String msg = "Стена высотой " +
                    course.getWall().getHeight() +
                    "м. - это слишком высокая приграда для кота!!!\nКот " +
                    name + " не смог перепрыгнуть стену";
            throw new TooHeightException(msg);
        } else {
            flagJump = true;
            System.out.println("Кот " + name + " смог перепрыгнуть стену высотой " + course.getWall().getHeight() + "м.");
        }
    }

    @Override
    public void showVictoryStatus(ObstacleCourse course) {
        System.out.print("ИТОГИ ТУРНИРА:\n");
        if (flagJump && flagRun) {
            System.out.println("\tКот " + name + " смог преодолеть полосу препятствий:" + course.toString());
        } else {
            System.out.println("\tКот " + name + " НЕ смог преодолеть полосу препятствий:" + course.toString());
        }
    }
}
