package com.UI;

import javax.swing.*;
import java.awt.Image;
import java.net.URL;

public class Pieces implements Comparable{

    private int x;
    private int y;
    private Image image;

    private int index;

    public Pieces(int x, int y) {
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

    public MovePiece(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("images/moving_piece.png");
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);

    }
}
class BoardPiece extends Pieces {

    private Image image;

    public BoardPiece(int x, int y) {
        super(x, y);

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

        URL loc = this.getClass().getResource("images/base_piece.png");
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);

    }
}