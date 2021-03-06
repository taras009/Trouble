package com.UI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Pieces implements Comparable {

    private int x;
    private int y;
    private Image image;

    private int index;

    public Pieces(int x, int y) {
        System.out.println("constructor for Pieces");
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        return (Integer.compare(this.getIndex(), ((Pieces) o).getIndex()));
    }
}

class MovePiece extends Pieces {

    private Image image;

    public MovePiece(int x, int y,OurColor color) {
        super(x, y);
        URL loc;
        switch (color) {
            case RED:
                loc = this.getClass().getResource("images/red_move.png64");
                break;
            case GREEN:
                loc = this.getClass().getResource("images/green_move.png64");
                break;
            case YELLOW:
                loc = this.getClass().getResource("images/yellow_move.png64");
                break;
            case BLUE:
                loc = this.getClass().getResource("images/blue_move.png64");
                break;
            default:
                loc = this.getClass().getResource("images/moving_piece.png");
        }
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);

    }
}

class BoardPiece extends Pieces {

    private Image image;

    public BoardPiece(int x, int y) {
        super(x, y);
        System.out.println("constructor for Board Piece");
        URL loc = this.getClass().getResource("images/board_piece.png");
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);

    }
}

class BasePiece extends Pieces {

    private Image image;

    public BasePiece(int x, int y) {
        super(x, y);
        URL loc = null;
        System.out.println("Constructor for Base Piece" + x + " " + y);
        if (x <= 100 && y <= 100) {
            loc = this.getClass().getResource("images/red.png64");
        } else if (x <= 100 && y >= 500) {
            loc = this.getClass().getResource("images/green.png64");
        } else if (x > 100 && y <= 100) {
            loc = this.getClass().getResource("images/blue.png64");
        } else if (x > 100 && y >= 500) {
            loc = this.getClass().getResource("images/yellow.png64");
        }
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();

        this.setImage(image);

    }
}
