package ru.geekbrains.alex.homework.part2.les1;

public class Distance {
    private int length;

    public Distance(int length) {
        this.length = length;
    }

    public boolean overcome(IAction member) {
        if (member.run() >= length) {
            System.out.println(member.getClass().getSimpleName() + "\'" + member.info() + "\' пробежал дистанцию длиной " + length + "м.");
            return true;
        }
        System.out.println(member.getClass().getSimpleName() + "\'" + member.info() + "\' не пробежал дистанцию длиной " + length + "м.");
        return false;
    }
}
