package ru.geekbrains.alex.homework.part1.les5;

public class Task5Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Петров Петр Петрович", "менеджер", "petrovInfo@gmail.com", "56-08", 1560.45, 28);
        employees[1] = new Employee("Иванов Иван Иванович", "топ-менеджер", "ivanovInfo@gmail.com", "95-18", 41560.45, 44);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "директор", "sidorovInfo@gmail.com", "01-12", 478160.45, 41);
        employees[3] = new Employee("Борисов Борис Борисович", "охранник", "securityInfo@gmail.com", "02-02", 15760.45, 47);
        employees[4] = new Employee("Антонов Яков Фомич", "мерчендайзер", "antonovInfo@gmail.com", "1547-59895-656111-08 доп 35889-874488-32358", 1562540.45, 58);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].showInfo();
            }
        }
    }
}
