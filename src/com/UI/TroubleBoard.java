package com.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TroubleBoard {
    private JButton rollButton;
    private JPanel panel1;
    private JButton button;

    public static void main(String[] args) {
        new TroubleBoard().createBoard();
    }

    public void createBoard(){
        JFrame frame = new JFrame(); // create frame
        button = new JButton("Click Me"); // create button
        JPanel panel = new JPanel();

        // frame configs
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);
        // button configs
        button.setSize(100,20);
        button.setLocation(50,50);
        //
        panel.add(button);
        //
        button.addActionListener(new ButtonListener()); // make button respond to clicks

    }
    class ButtonListener implements ActionListener{ //inner class for clicks

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText("I'm clicked!");


        }
    }
}