package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TroubleBoard {
    int x = 10, y = 30; // ***initial image location
    MyDrawPanel drawPanel = new MyDrawPanel();
    private JButton rollButton;
    private JPanel panel1;
    private JButton button;
    private JFrame frame;

    public static void main(String[] args) throws IOException {
        new TroubleBoard().createBoard();
    }

    public void createBoard() throws IOException {
        frame = new JFrame(); // ***create frame
        button = new JButton("Click Me"); // ***create button
        //
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); //***set up drawpanel location on frame
        frame.getContentPane().add(BorderLayout.NORTH, button); // ***set up button location on frame
        // ***frame configs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //frame.setContentPane(panel);
        // ***button configs
        button.setSize(100, 20);
        button.setLocation(50, 50);
        //
        //frame.add(button);
        // panel.add(button);

        button.addActionListener(new ButtonListener()); // ***make button respond to clicks
    }
    public void animation(){
        x++;
        y++;
        frame.repaint();
    }

    class ButtonListener implements ActionListener { //*** inner class for clicks

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText("I'm clicked!");
            animation();
        }
    }// close ButtonListener

    class MyDrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            // *** creating blue rectangle***
            g.setColor(Color.blue);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            // *** adding image with initial location
            Image image = new ImageIcon("src/Images/token_0.jpg").getImage();
            g.drawImage(image, x, y, this);

        }
    }
}//close TroubleBoard