package ru.geekbrains.alex.homework.les6;

public abstract class Animal implements Runnable, Swimmable{

    String name;

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
