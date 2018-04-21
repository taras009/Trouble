package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TroubleBoard {

    PopOMatic popOMatic = new PopOMatic();

    MyDrawPanel drawPanel = new MyDrawPanel();
    int position = 0;
    private JPanel buttonPanel;
    private JButton button;
    private JButton piece1;
    private JButton piece2;
    private JButton piece3;
    private JButton piece4;
    private JLabel ch;
    private JButton resetButton;
    private JFrame frame;

    public static void main(String[] args) throws IOException {
        //initiate board
        //Board board = new Board();


        new TroubleBoard().createBoard();
    }

    public void createBoard() throws IOException {
        System.out.println("Trouble Board:create Board");
        frame = new JFrame(); // ***create frame
        button = new JButton("MOVE--> " + drawPanel.chanceToPlay); // ***create button
        piece1 = new JButton("1");
        piece2 = new JButton("2");
        piece3 = new JButton("3");
        piece4 = new JButton("4");
        buttonPanel = new JPanel();
        buttonPanel.setSize(30, 650);
        buttonPanel.setLocation(650, 0);
        buttonPanel.add(BorderLayout.CENTER, piece1);
        buttonPanel.add(piece2);
        buttonPanel.add(piece3);
        buttonPanel.add(piece4);
//        buttonPanel.add(BorderLayout.CENTER,ch);

        resetButton = new JButton("Reset"); //***create button
        //
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); //***set up drawPanel location on frame
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.getContentPane().add(BorderLayout.EAST, buttonPanel); // ***set up button location on frame
        //frame.getContentPane().add(BorderLayout.EAST,piece2);
        //frame.getContentPane().add(BorderLayout.EAST,piece3);
        //frame.getContentPane().add(BorderLayout.EAST,piece4);
        frame.getContentPane().add(BorderLayout.SOUTH, resetButton);
        // ***frame configs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        //frame.setLocationRelativeTo(null);
        // ***button configs
        frame.pack();
        // button.setLocation(50, 50);
        ButtonListener bb = new ButtonListener();
        button.addActionListener(new ButtonListener());
        piece1.addActionListener(bb); // ***make button respond to clicks
        piece2.addActionListener(bb);
        piece3.addActionListener(bb);
        piece4.addActionListener(bb);
        buttonControl(false, false, false, false);


        resetButton.addActionListener(new ResetButtonListener());

    }

    public void buttonControl(boolean a, boolean b, boolean c, boolean d) {
        piece1.setEnabled(a);
        piece2.setEnabled(b);
        piece3.setEnabled(c);
        piece4.setEnabled(d);
    }


    public void isWinner() {
        if (drawPanel.redI[0] == -10 && drawPanel.redI[1] == -10 && drawPanel.redI[2] == -10 && drawPanel.redI[2] == -10) {
            position++;
            button.setText("RED Position : " + position);
        }

        if (drawPanel.blueI[0] == -10 && drawPanel.blueI[1] == -10 && drawPanel.blueI[2] == -10 && drawPanel.blueI[2] == -10) {
            position++;
            button.setText("BLUE Position : " + position);
        }

        if (drawPanel.yellowI[0] == -10 && drawPanel.yellowI[1] == -10 && drawPanel.yellowI[2] == -10 && drawPanel.yellowI[2] == -10) {
            position++;
            button.setText("YELLOW Position : " + position);
        }

        if (drawPanel.greenI[0] == -10 && drawPanel.greenI[1] == -10 && drawPanel.greenI[2] == -10 && drawPanel.greenI[2] == -10) {
            position++;
            button.setText("GREEN Position : " + position);
        }
    }

    //checks if there are any moves available
    public int MovesAvailable() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (drawPanel.HasMove(i, drawPanel.diceNumber)) {
                count++;
            }
        }
        return count;
    }

    class ButtonListener implements ActionListener { //*** inner class for clicks

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("dice rolling");
            if (e.getSource() == button) {
                drawPanel.diceNumber = popOMatic.Roll();


                if (MovesAvailable() > 1) {
                    button.setEnabled(false);
                    buttonControl(drawPanel.HasMove(0, drawPanel.diceNumber), drawPanel.HasMove(1, drawPanel.diceNumber),
                            drawPanel.HasMove(2, drawPanel.diceNumber), drawPanel.HasMove(3, drawPanel.diceNumber));
                } else {
                    //auto move
                    if (MovesAvailable() == 1) {
                        for (int i = 0; i < 4; i++) {
                            if (drawPanel.HasMove(i, drawPanel.diceNumber)) {
                                drawPanel.move(drawPanel.diceNumber, i);
                            }
                        }
                    }
                    //if no moves, go to next player
                    else {
                        drawPanel.updateChanceToPlay();
                    }
                    button.setText("MOVE--> " + drawPanel.chanceToPlay);
                }

            } else if (e.getSource() == piece1 || e.getSource() == piece2 || e.getSource() == piece3 || e.getSource() == piece4) {
                if (e.getSource() == piece1) {
                    drawPanel.move(drawPanel.diceNumber, 0);
                }
                if (e.getSource() == piece2) {
                    drawPanel.move(drawPanel.diceNumber, 1);
                }
                if (e.getSource() == piece3) {
                    drawPanel.move(drawPanel.diceNumber, 2);
                }
                if (e.getSource() == piece4) {
                    drawPanel.move(drawPanel.diceNumber, 3);
                }
                button.setEnabled(true);
                buttonControl(false, false, false, false);
                button.setText("MOVE--> " + drawPanel.chanceToPlay);
            } else {
                isWinner();
            }
            frame.repaint();
        }
    }// close ButtonListener

    // restart game
    class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            //Board board = new Board();
            try {
                new TroubleBoard().createBoard();
            } catch (IOException ee) {
                System.out.println(ee.getMessage());
            }
            drawPanel.restart();
            frame.repaint();
        }
    }
}//close TroubleBoard
