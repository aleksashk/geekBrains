package ru.geekbrains.alex.homework.les7;

public class DZ7MainApp {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsic", 5), new Cat("Chashcka", 50), new Cat("Bricket", 70), new Cat("Vagon", 500), new Cat("Acord", 200)};
        Plate plate = new Plate(500);
        plate.info();

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println("Кот " + cat.getName() + " сcыт - " + cat.isSatiety());
        }

        plate.info();

        plate.increaseFood(800);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println("Кот " + cat.getName() + " сcыт - " + cat.isSatiety());
        }

        plate.info();

    }
}
