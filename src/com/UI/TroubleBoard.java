package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TroubleBoard {

    PopOMatic popOMatic = new PopOMatic();

    MyDrawPanel drawPanel = new MyDrawPanel();

    private JButton button;
    private JButton resetButton;
    private JFrame frame;

    public static void main(String[] args) throws IOException {
        //initiate board
        Board board = new Board();


        // initiate player rotation


        //begin plyer turns
        while (!board.AnyWinners())
        {
            for (int i = 0; i <board.players.length ; i++) {
                int roll = 0;
                do {
                    roll = board.die.Roll();
                    //Turn stuff here




                }while(roll == 6);

            }
        }

        //display winner message


        
        //integrate with board

        new TroubleBoard().createBoard();
    }

    public void createBoard() throws IOException {
        frame = new JFrame(); // ***create frame
        button = new JButton("MOVE"); // ***create button
        resetButton = new JButton("Reset"); //***create button
        //
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); //***set up drawPanel location on frame
        frame.getContentPane().add(BorderLayout.NORTH, button); // ***set up button location on frame
        frame.getContentPane().add(BorderLayout.SOUTH, resetButton);
        // ***frame configs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        // ***button configs
        button.setSize(100, 20);
        // button.setLocation(50, 50);
        button.addActionListener(new ButtonListener()); // ***make button respond to clicks
        resetButton.addActionListener(new ResetButtonListener());

    }

    class ButtonListener implements ActionListener { //*** inner class for clicks
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = popOMatic.Roll();
            drawPanel.move(i);
            frame.repaint();
            System.out.println(i); //
        }
    }// close ButtonListener

    class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawPanel.restart();
            frame.repaint();
        }
    }
}//close TroubleBoard