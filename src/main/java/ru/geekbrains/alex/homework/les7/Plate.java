package ru.geekbrains.alex.homework.les7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void increaseFood(int n) {
        food += n;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        System.out.println("Кот не может съесть еды больше, чем находится в тарелке. Кот остался голодным");
        return false;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
