package ru.geekbrains.alex.homework.part1.les7;

public class Cat {
    private final String name;
    private final int appetite;
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
            if(appetite > p.getFood()){
                System.out.println("Кот " + name + " не может съесть еды больше, чем находится в тарелке. " +
                        "\nКот " + name + " остался голодным");
            }else {
                satiety = true;
            }
        } else {
            System.out.println("Кот " + name +  " сыт и есть не будет");
        }
    }
}
