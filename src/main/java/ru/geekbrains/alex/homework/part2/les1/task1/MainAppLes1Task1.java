package ru.geekbrains.alex.homework.part2.les1.task1;

public class MainAppLes1Task1 {
    public static void main(String[] args) {
        Jumpable jumper1 = new Cat("Vasek", 2, "gray");
        Jumpable jumper2 = new People("Adam", 25);
        Jumpable jumper3 = new Robot("ЩА-23", 458007, "шустрый");
        Jumpable jumper4 = new Cat("Vasek", 2, "gray");
        Jumpable jumper5 = new People("Dmitry", 74);
        Jumpable jumper6 = new Robot("УРДВ-7о10", 254788, "шпала");

        Jumpable[] jumpables = new Jumpable[6];

        jumpables[0] = jumper1;
        jumpables[1] = jumper2;
        jumpables[2] = jumper3;
        jumpables[3] = jumper4;
        jumpables[4] = jumper5;
        jumpables[5] = jumper6;

        for (Jumpable jumper : jumpables) {
            jump(jumper);
        }

        Movable runner1 = new Cat("Gogol", 8, "white");

        Movable runner2 = new People("Pavel", 40);

        Movable runner3 = new Robot("КУВЕ-014", 10000015, "транклюкатор");

        Movable runner4 = new Cat("Murka", 7, "black");

        Movable runner5 = new People("Ivanka", 15);

        Movable runner6 = new Robot("QWERTY-078", 45444692, "COP");


        Movable[] runners = new Movable[6];

        runners[0] = runner1;
        runners[1] = runner2;
        runners[2] = runner3;
        runners[3] = runner4;
        runners[4] = runner5;
        runners[5] = runner6;

        for (Movable runner : runners) {
            move(runner);
        }
    }

    public static void jump(Jumpable essence) {
        essence.jump();
    }

    public static void move(Movable essence) {
        essence.move();
    }


}
