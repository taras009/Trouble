package com.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyDrawPanel extends JPanel {
    public static final int OFFSET = 0;
    public static final int SPACE = 50;

    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;

    public int index =1;

    private ArrayList<Pieces>allPieces = new ArrayList<Pieces>();
    private ArrayList<MovePiece> movePieces = new ArrayList<MovePiece>();

    public int x = 250;
    public int y = 0;

    private String level =
            "#####&&&#####\n"
                    + "#$$##&#&##$$#\n"
                    + "#$$##&#&##$$#\n"
                    + "#####&#&#####\n"
                    + "#####&#&#####\n"
                    + "&&&&&&#&&&&&&\n"
                    + "&###########&\n"
                    + "&&&&&&#&&&&&&\n"
                    + "#####&#&#####\n"
                    + "#####&#&#####\n"
                    + "#$$##&#&##$$#\n"
                    + "#$$##&#&##$$#\n"
                    + "#####&&&#####\n";

    int[] piecesOrder = {1,2,3,48,4,47,5,46,6,45,7,39,40,41,42,43,44,
            8,9,10,11,12,13,38,14,37,36,35,34,33,32,20,
            19,18,17,16,15,31,21,30,22,29,23,28,24,27,26,25};


    public MyDrawPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initWorld();
    }

    public final void initWorld() {

        int x = OFFSET;
        int y = OFFSET;

        BoardPiece boardPiece;
        MovePiece movePiece;
        BasePiece basePiece;
        int ii = 0;

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = OFFSET;
            } else if (item == '#') {
                boardPiece = new BoardPiece(x, y);
                allPieces.add(boardPiece);
                x += SPACE;
            } else if (item == '&') {
                movePiece = new MovePiece(x, y);
                movePiece.setIndex(piecesOrder[ii++]);
                allPieces.add(movePiece);
                movePieces.add(movePiece);

                x += SPACE;
            } else if (item == '$') {
                basePiece = new BasePiece(x, y);
                allPieces.add(basePiece);
                x += SPACE;
            }

        }
        Collections.sort(movePieces);

        }


    public void buildWorld(Graphics g) {

        for (int i = 0; i < allPieces.size(); i++) {

            Pieces item = (Pieces) allPieces.get(i);


            g.drawImage(item.getImage(), item.x(), item.y(), this);

        }
        Image image = new ImageIcon(this.getClass().getResource("Images/player.png")).getImage();
        g.drawImage(image, x,   y, this);

    }

    public void move(){
        x = movePieces.get(index).x();
        y = movePieces.get(index).y();
        index++;
        if(index > 47){
            index = 0;
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }



    public void restart() {
        x = 250;
        y = 0;
    }
}