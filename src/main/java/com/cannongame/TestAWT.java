package com.cannongame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestAWT {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AWT Test");
        JLabel label = new JLabel("AWT is working!", JLabel.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
