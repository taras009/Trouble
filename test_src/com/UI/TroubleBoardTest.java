package com.UI;

import org.junit.Test;

import javax.swing.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class TroubleBoardTest  {


    @Test
    public void testButtonControl1()
    {
        TroubleBoard a = new TroubleBoard();
        try {
            a.createBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        a.buttonControl(true, false, true, false);
       assert(a.piece1.isEnabled() );
        assert(!a.piece2.isEnabled() );
        assert(a.piece3.isEnabled() );
        assert(!a.piece4.isEnabled() );
    }
    @Test
    public void testButtonControl2()
    {
        TroubleBoard a = new TroubleBoard();
        try {
            a.createBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        a.buttonControl(false, true, false, true);
        assert(!a.piece1.isEnabled() );
        assert(a.piece2.isEnabled() );
        assert(!a.piece3.isEnabled() );
        assert(a.piece4.isEnabled() );
    }

}