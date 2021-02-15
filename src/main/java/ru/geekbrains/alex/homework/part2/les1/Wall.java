package ru.geekbrains.alex.homework.part2.les1;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean overcome(ICourse member) {

        if (member.jump() >= height) {
            System.out.println(member.getClass().getSimpleName() + "\'" + member.info() + "\' перепрыгнул стену высотой " + height + "м.");
            return true;
        }
        System.out.println(member.getClass().getSimpleName() + "\'" + member.info() + "\' не перепрыгнул стену высотой " + height + "м.");
        return false;
    }
}
