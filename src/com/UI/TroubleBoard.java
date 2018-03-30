package com.UI;

import com.UI.PopOMatic;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;

public class TroubleBoard {
    int x = 0, y = 0; // ***initial image location


    MyDrawPanel drawPanel = new MyDrawPanel();

    PopOMatic popOMatic = new PopOMatic();

    private JButton button;
    private JButton resetButton;
    private JFrame frame;

    public static void main(String[] args) throws IOException {
        new TroubleBoard().createBoard();
    }

    public void createBoard() throws IOException {
        frame = new JFrame(); // ***create frame
        button = new JButton("Click Me"); // ***create button
        resetButton = new JButton("Reset"); //***create button
        //
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); //***set up drawPanel location on frame
        frame.getContentPane().add(BorderLayout.NORTH, button); // ***set up button location on frame
        frame.getContentPane().add(BorderLayout.SOUTH, resetButton);
        // ***frame configs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setContentPane(panel);
        // ***button configs
        button.setSize(100, 20);
        // button.setLocation(50, 50);
        //
        button.addActionListener(new ButtonListener()); // ***make button respond to clicks
        resetButton.addActionListener(new ResetButtonListener());
    }

    public void move(int diceNumber) {
        while (diceNumber != 0) {
            x += 100;
            if (x >= 800) {
                y += 100;
                x = 0;
            }
            diceNumber--;
//            try {
//                Thread.sleep(50);
//            } catch (Exception ex) {
//            }
            frame.repaint();
        }
    }

    public int getCenterPointX() {
        return frame.getWidth() / 2;
    }

    public int getCentralPointY() {
        return frame.getHeight() / 2;
    }

    class ButtonListener implements ActionListener { //*** inner class for clicks

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText("I'm clicked!");
            int diceNumber = popOMatic.Roll();
            move(diceNumber);

        }
    }// close ButtonListener

    class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            x = 0;
            y = 0;
            frame.repaint();
        }
    }

    class MyDrawPanel extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g; // ability to use g2 methods on g

            // *** creating blue rectangle***
            //   int width = this.getWidth() / 8;// shortcut
            // int height = this.getHeight() / 8;// shortcut
            int width = frame.getWidth();
            int height = frame.getHeight();

            for (int i = 0; i <= width; i += width / 8) {
                {
                    g.setColor(Color.blue);
                    //g2.setStroke(this);
                    g.drawRect(i, 0, 100, 100);
                    g.setColor(Color.red);
                    // g2.fillOval(i,0,100,100);
                    //g.fillRect(j,i,width,height);
                }
            }
              // *** adding image with initial location
            Image image = new ImageIcon("src/Images/catt.jpg").getImage();
            g.drawImage(image, x, y, this);

            // ***creating squares ***
            g.setColor(Color.gray);
            g.fillOval(getCenterPointX(), getCentralPointY(), 40, 40);
            g.drawString(String.valueOf(1), getCenterPointX(), getCentralPointY());
            System.out.println(getCenterPointX());
            System.out.println(getCentralPointY());

        }
    }
}//close TroubleBoard