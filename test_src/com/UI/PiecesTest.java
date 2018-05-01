package com.UI;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PiecesTest {

    @Test
    public void getImage() {
        Image expectedImage; // Not sure what should I enter here
        Pieces pieces = new Pieces(expectedImage);
        assertNotNull(Image expectedImage);
    }

    @Test
    public void setImage() {
    }

    @Test
    public void x() {
        int expectedX; // Not sure what should I enter here
        Pieces pieces = new Pieces(expectedX, 0);
        Assert.assertNotNull(expectedX, pieces.x());
    }

    @Test
    public void y() {
        int expectedY = 6; // Not sure what should I enter here
        Pieces pieces = new Pieces(expectedY, 0);
        Assert.assertEquals(expectedY, pieces.y());
    }

    @Test
    public void getIndex() {
        int expectedIndex = 6;
        Pieces pieces = new Pieces(expectedIndex, 0);
        Assert.assertEquals(expectedIndex, pieces.y());

    }

    @Test
    public void setIndex() {
        int expectedIndex = 6;
        Pieces pieces = new Pieces(expectedIndex, 0);
        Assert.assertEquals(expectedIndex, pieces.y());
    }

    @Test
    public void compareTo() {
    }
}