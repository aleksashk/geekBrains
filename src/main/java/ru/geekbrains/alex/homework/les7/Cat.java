package ru.geekbrains.alex.homework.les7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite) && !satiety) {
            satiety = true;
        } else {
            System.out.println("Кот сыт и есть не будет");
        }
    }
}
