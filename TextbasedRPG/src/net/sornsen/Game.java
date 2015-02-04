package net.sornsen;

import javax.swing.*;

/**
 * Created by Admin on 03-02-2015.
 */
public class Game {

    public static void main(String[] args) {
        JFrame window = new JFrame("Platform");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new GamePanel());
        window.pack();
        window.setVisible(true);
    }
}
