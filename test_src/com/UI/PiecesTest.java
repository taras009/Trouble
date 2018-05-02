package com.UI;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PiecesTest {

    @Test
    public void getImage() {
        Image expectedImage = new BasePiece(0,0).getImage();
        Pieces pieces = new Pieces(0,0);
        pieces.setImage(expectedImage);
        assertNotNull(pieces.getImage());
    }

    @Test
    public void setImage() {
// setImage
    }

    @Test
    public void x() {
        int expectedX = 6;
        Pieces pieces = new Pieces(expectedX, 0);
        Assert.assertNotNull(pieces.x());
    }

    @Test
    public void y() {
        int expectedY = 0;
        Pieces pieces = new Pieces(expectedY, 0);
        Assert.assertEquals(expectedY, pieces.y());
    }

    @Test
    public void getIndex() {
        int expectedIndex = 6;
        Pieces pieces = new Pieces(0,0);
        pieces.setIndex(expectedIndex);
        assertNotNull(pieces.getIndex());

    }

    @Test
    public void setIndex() {
        int expectedIndex = 0;
        Pieces pieces = new Pieces(expectedIndex, 0);
        Assert.assertEquals(expectedIndex, pieces.y());
    }

    @Test
    public void compareTo() {
       /*
        int compareVal1 = 4;
        Pieces pieces = new Pieces(compareVal1, 0);
        Assert.assertEquals(compareVal1, pieces.compareTo(compareVal1));
        */
    }
}