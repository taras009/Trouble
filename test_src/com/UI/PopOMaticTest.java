package com.UI;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PopOMaticTest {

    @Test
    public void roll() {
        Random rand = new Random();
        int nxt = rand.nextInt(6);
        assertEquals(true, (nxt < 6));

        }
    }