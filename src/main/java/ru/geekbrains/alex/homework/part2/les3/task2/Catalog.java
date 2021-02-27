package ru.geekbrains.alex.homework.part2.les3.task2;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, String> phoneBook;

    public Catalog() {
        phoneBook = new HashMap<>();
    }

    public void add(Person person) {
        phoneBook.put(person.getPhone(), person.getLastName());
    }

    public void getPhone(String lastName) {
        if (!phoneBook.containsValue(lastName)) {
            System.out.println("с фамилией \'" + lastName + "\' в справочнике никто не найден");
        }else {
            System.out.println(lastName + ':');
            for (Map.Entry<String, String> item : phoneBook.entrySet()) {
                if ((lastName).equals(item.getValue())) {
                    System.out.println('\t' + item.getKey());
                }
            }
        }
        System.out.println("-------------------------------");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog: \n");

        for (Map.Entry<String, String> item : phoneBook.entrySet()) {
            sb.append('\t').append(item.getValue()).append(": ").append(item.getKey()).append(";\n");
        }
        sb.append("-------------------------------");
        return new String(sb);
    }
}
