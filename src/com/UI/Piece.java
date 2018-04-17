package com.UI;

public class Piece {
    public int Location;

    public Piece(int location){
        Location = location;
    }
    public boolean IsHome() {
        System.out.println("Piece: Is Home");
        return this.Location < 44 && this.Location > 27;
    }

    public boolean IsFinish() {
       System.out.println("Piece:IsFinish");
        return this.Location > 43;
    }

}
