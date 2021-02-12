package ru.geekbrains.alex.homework.part2.les1.task1;

import static ru.geekbrains.alex.homework.part2.les1.task1.Printer.print;

public class Robot  implements Movable, Jumpable{
    private String model;
    private int serialID;
    private String login;

    public Robot(String model, int serialID, String login) {
        this.model = model;
        this.serialID = serialID;
        this.login = login;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialID() {
        return serialID;
    }

    public void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void jump() {
        print("Robot \'" + login + "\', model: \'" + model + "\' is jumping");
    }

    @Override
    public void move() {
        print("Robot \'" + login + "\', model: \'" + model + "\' is running");
    }
}
