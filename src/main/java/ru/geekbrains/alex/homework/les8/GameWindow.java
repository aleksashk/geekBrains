package ru.geekbrains.alex.homework.les8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public boolean isWin;
    public int minNumber = 0;
    public int maxNumber = 100;
    public int number;
    public int target = (int) (Math.random() * (maxNumber - minNumber)) + minNumber;

    void tryToFindNumber() {
        number = (int) (Math.random() * (maxNumber - minNumber)) + minNumber;
    }

    public GameWindow() throws HeadlessException {

        setTitle("GuessTheNumbeR");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 150, 400, 700);

        JTextArea message = new JTextArea();
        JScrollPane jsp = new JScrollPane(message);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        add(bottomPanel, BorderLayout.SOUTH);

        JButton buttonPlayAgain = new JButton("press to restart game");
        buttonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minNumber = 0;
                maxNumber = 100;
                target = (int) (Math.random() * (maxNumber - minNumber)) + minNumber;
                isWin = false;
                message.setText("");
            }
        });

        JButton buttonPlay = new JButton("press to play");
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isWin) {
                    tryToFindNumber();
                    message.append("Рандом выдал вам число " + number + "\n");

                    if (number == target) {
                        message.append("Святой РАНДОМ выдал вам ПРАВИЛЬНОЕ число" +
                                "\n\tВЫ ВЫИГРАЛИ!!!\n");
                        isWin = true;
                    } else {
                        if (number > target) {
                            message.append("Святой РАНДОМ выдал вам число, которое больше загаданного" +
                                    "\n\tПопробуйте еще разочек.\n");
                            maxNumber = number--;
                        } else {
                            message.append("Святой РАНДОМ выдал вам число, которое меньше загаданного" +
                                    "\n\tПопробуйте еще разочек.\n");
                            minNumber = number++;
                        }
                    }
                }
            }
        });

        bottomPanel.add(buttonPlay);
        bottomPanel.add(buttonPlayAgain);

        setVisible(true);
    }
}
