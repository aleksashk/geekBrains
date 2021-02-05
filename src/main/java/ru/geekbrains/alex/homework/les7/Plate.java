package ru.geekbrains.alex.homework.les7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void increaseFood(int n) {
        System.out.println("добавляем " + n + " еды в тарелку");
        food += n;
        System.out.println("теперь в тарелке осталось " + n + " еды");
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("еды в тарелке осталось: " + food);
    }
}
