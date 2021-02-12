package ru.geekbrains.alex.homework.part1.les6;

public abstract class Animal implements Runnable, Swimmable {
    static int counterOfAnimal = 0;
    String name;

    public Animal(String name) {
        counterOfAnimal++;
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
