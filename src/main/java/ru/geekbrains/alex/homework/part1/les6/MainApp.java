package ru.geekbrains.alex.homework.part1.les6;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static final List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Animal animal1 = new Cat("Васька");
        Animal animal2 = new Cat("Петька");
        Animal animal3 = new Cat("Санька");
        Animal animal4 = new Cat("Жучка");
        Animal animal5 = new Cat("Себастиан");
        Animal animal6 = new Cat("Вектор");
        Animal animal7 = new Cat("Роберт");
        Animal animal8 = new Cat("Лишай");
        Animal animal9 = new Dog("Собакен");
        Animal animal10 = new Dog("Рыжий");
        Animal animal11 = new Dog("Додж");
        Animal animal12 = new Dog("Ушатый");
        Animal animal13 = new Dog("Рекс");
        Animal animal14 = new Dog("Дастер");
        Animal animal15 = new Dog("БРИКЕТ");
        Animal animal16 = new Dog("ШариК");
        Animal animal17 = new Dog("ШариК-2");
        Animal animal18 = new Dog("ШариК-3");

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal6);
        animals.add(animal7);
        animals.add(animal8);
        animals.add(animal9);
        animals.add(animal10);
        animals.add(animal11);
        animals.add(animal12);
        animals.add(animal13);
        animals.add(animal14);
        animals.add(animal15);
        animals.add(animal16);

        action();

        String msg = "Всего котов создано: " + Cat.countOfCat + "шт." +
                "\nВсего собак создано: " + Dog.countOfDog + "шт." +
                "\nВсего животных создано: " + Animal.counterOfAnimal + "шт.";
        Printer.print(msg);

    }

    public static void action() {
        for (int i = 50; i < 600; i += 50) {
            for (Animal animal : animals) {
                animal.run(i);
                animal.swim(i);
            }
        }
    }
}
//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра
// каждому методу передается длина препятствия. Результатом
// выполнения действия будет печать в консоль. (Например,
// dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия
// (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.