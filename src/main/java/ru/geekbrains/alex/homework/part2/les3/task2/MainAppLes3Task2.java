package ru.geekbrains.alex.homework.part2.les3.task2;

import java.util.ArrayList;

public class MainAppLes3Task2 {
    public static void main(String[] args) {
        Person person1 = new Person("Ivanova", "365-554-882");
        Person person2 = new Person("Ivanova", "215-500-147");
        Person person3 = new Person("Crotov", "123-123-123");
        Person person4 = new Person("Petrov", "234-234-234");
        Person person5 = new Person("Scvortsov", "145-654-621");
        Person person13 = new Person("Scvortsov", "132-000-621");
        Person person6 = new Person("Ivanova", "100-200-300");
        Person person7 = new Person("Ivanova", "124-000-410");
        Person person8 = new Person("Romanov", "142-251-321");
        Person person9 = new Person("Jonson", "54-022");
        Person person10 = new Person("Rock", "124");
        Person person11 = new Person("Jonson", "96-8442");
        Person person12 = new Person("Petrov", "145-832-010");
        Person person17 = new Person("Petrov", "285-857-170");
        Person person14 = new Person("Petrov", "145-800-001");
        Person person15 = new Person("Petrov", "324-847-040");
        Person person16 = new Person("Petrov", "145-177-030");

        Catalog catalog = new Catalog();
        catalog.add(person1);
        catalog.add(person2);
        catalog.add(person3);
        catalog.add(person4);
        catalog.add(person5);
        catalog.add(person6);
        catalog.add(person7);
        catalog.add(person8);
        catalog.add(person9);
        catalog.add(person10);
        catalog.add(person11);
        catalog.add(person12);
        catalog.add(person13);
        catalog.add(person14);
        catalog.add(person15);
        catalog.add(person16);
        catalog.add(person17);

        System.out.println(catalog);

        catalog.getPhone("Ivanova");
        catalog.getPhone("Petrov");
        catalog.getPhone("Crotov");
        catalog.getPhone("Krotov");
        catalog.getPhone("Scvortsov");
    }
}

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
//телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
//учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
//лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
//через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
//справочника.