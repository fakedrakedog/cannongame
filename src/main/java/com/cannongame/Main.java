package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
public class Main extends JFrame {
    PaintableBall ball;

    public void setBall(PaintableBall ball) {
        this.ball = ball;
    }

    public static void main(String[] args) {
        Main frame = new Main();

        frame.setSize(200, 200);
        frame.setBall(new PaintableBall(100, 100, 50, Color.blue));
        frame.setVisible(true);
        frame.setEnabled(true);

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if(ball != null){
            ball.paint(g);
        }
    }
}
