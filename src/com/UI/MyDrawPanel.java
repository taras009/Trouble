package com.UI;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;

    int centralPointX = WIDTH / 2;
    int getCentralPointY = HEIGHT / 2;

    int x = 0;
    int y = 0;

    public MyDrawPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // ability to use g2 methods on g
        // *** creating squares***
        for (int i = 0; i <= WIDTH; i += WIDTH / 9) {
            for (int j = 0; j <= HEIGHT; j +=HEIGHT/6) {
                g.setColor(Color.blue);
                g.drawRect(i, j, 100, 100);
                g.setColor(Color.lightGray);
                g.fillOval(i, j, 100, 100);
                //g.fillRect(j,i,100,100);
            }
        }
        // *** adding image with initial location
        Image image = new ImageIcon("src/Images/catt.jpg").getImage();
        g.drawImage(image, x, y, this);
    }


    public void move(int diceNumber) {
        while (diceNumber != 0) {
            x += 100;
            if (x >= WIDTH) {
                y += 100;
                x = 0;
            }
            diceNumber--;
        }
    }

    public void restart() {
        x = 0;
        y = 0;
    }
}