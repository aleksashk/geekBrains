package ru.geekbrains.alex.homework.part2.les3.task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainAppLes3Task1 {
    public static void main(String[] args) {
        String[] strings = {"Бег", "Плавание", "Дайвиг", "Бег", "Закаливане", "Стрельба из лука", "Карате", "Прыжки в воду", "Бег", "Дайвиг", "Бег", "Стрельба из лука", "Бег", "Дайвиг", "Плавание", "Бег", "Карате", "Спортивные танцы", "Дайвиг", "Утренняя зарядка", "Бег", "Скандинавская ходьба", "Бег", "Армреслинг", "Бег", "Гимнастика", "Карате", "Бокс", "Гребля"};

        Set<String> stringSet = new HashSet<>(Arrays.asList(strings));

        System.out.println("Массив уникальных слов: " + stringSet);

        countOfString(strings, stringSet);
    }

    private static void countOfString(String[] strings, Set<String> stringSet) {
        for (String s : stringSet) {
            int counter = 0;
            for (String stringItem : strings) {
                if (s.equals(stringItem)) {
                    counter++;
                }
            }
            if (counter > 0) {
                System.out.println("Строка \'" + s + "\' повторяется в исходном массиве " + counter + (counter == 1 || counter >= 5 ? " раз" : " раза"));
            }
        }
    }
}

//Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
//вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Посчитать, сколько раз встречается каждое слово.