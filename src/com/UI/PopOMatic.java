package com.UI;

import java.util.Random;

public class PopOMatic {
    public PopOMatic() {
    }

    public int Roll(){
       
        Random rand = new Random();
        //returns the range of (0-5) and adds 1 to get a random number of 1-6
      
        return rand.nextInt(6)+1;
       
        
    }
}
