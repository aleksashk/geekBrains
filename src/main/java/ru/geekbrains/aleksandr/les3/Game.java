package ru.geekbrains.aleksandr.les3;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String msg;
    static String heroName;
    static String monsterName;
    static int travelDirection;
    static int heroHp, heroHpMax, heroAttack, heroClass;
    static int monsterHp, monsterHpMax, monsterAttack, monsterClass;
    static String[] classesNames = {"", "Варвар", "Славный рыцарь", "Разбойник"};

    public static void main(String[] args) {
        selectName();
        selectClass();
        msg = "Ваше приключение начинается!";
        print(msg);
        printPlayerInfo();

        travelPhase();
        if (travelDirection == 2) {
            battlePhase();
        }
        msg = "Вы прошли игру. Поздравляем!";
        print(msg);
    }

    private static void battlePhase() {
        generateMonster();
        msg = "Вы встречаете злобного монстра!";
        print(msg);
        printMonsterInfo();
        do {
            int playerAction = showUserAction("Ход играка. Выберите действие: ", "атаковать","защититься");

            if (playerAction == 1) {
                monsterHp -= heroAttack;
                msg = monsterName + " получил ед урона: " + heroAttack;
                print(msg);
            }
            if (playerAction == 2) {
                if (random.nextInt(100) < 5) {
                    heroHp++;
                    if (heroHp > heroHpMax) {
                        heroHp = heroHpMax;
                    }
                    msg = "Герой восстановил здоровье";
                    print(msg);
                } else {
                    msg = "Герой просто подождал";
                    print(msg);
                }
            }
            msg = "Ход монстра";
            print(msg);
            heroHp -= monsterAttack;
            msg = heroName + " получил ед урона: " + monsterAttack;
            print(msg);
            msg = "Состояние участников боя:";
            print(msg);
            printPlayerInfo();
            printMonsterInfo();

        } while (heroHp > 0 && monsterHp > 0);
    }

    public static void travelPhase() {
        travelDirection = showUserAction("Куда Вы хотите отправиться?", "Лес", "Пещера", "Горы");
    }

    public static int showUserAction(String question, String... variants) {
        int userInput;
        do {
            print(question);

            for (int i = 0; i < variants.length; i++) {
                print(i + 1 + ". " + variants[i]);
            }
            userInput = scanner.nextInt();
        } while (userInput < 1 || userInput > variants.length);
        return userInput;
    }

    public static void generateMonster() {
        int n = random.nextInt(2);
        switch (n) {
            case 0:
                monsterName = "Goblin";
                monsterHpMax = 4;
                monsterHp = monsterHpMax;
                monsterAttack = 1;
                break;
            case 1:
                monsterName = "Ogre";
                monsterHpMax = 5;
                monsterHp = monsterHpMax;
                monsterAttack = 2;
                break;
        }
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void selectName() {
        msg = "Вы начали своё путешествие. Введи своё имя, отважный Герой:";
        print(msg);
        heroName = scanner.nextLine();
    }

    public static void selectClass() {
        heroClass = showUserAction("Представься пожалуйста, каково твоё призвание?", "Варвар", "Славный рыцарь", "Разбойник");
        switch (heroClass) {
            case 1:
                heroHpMax = 6;
                heroAttack = 2;
                break;
            case 2:
                heroHpMax = 8;
                heroAttack = 1;
                break;
            case 3:
                heroHpMax = 4;
                heroAttack = 3;
                break;
        }
        heroHp = heroHpMax;
    }

    public static void printPlayerInfo() {
        msg = "Class: " + classesNames[heroClass] + " Name: " + heroName +
                " \nHP: " + heroHp + "/" + heroHpMax + " Attack: " + heroAttack;
        print(msg);
    }

    public static void printMonsterInfo() {
        msg = "Name: " + monsterName +
                " \nHP: " + monsterHp + "/" + monsterHpMax + " Attack: " + monsterAttack;
        print(msg);
    }
}
