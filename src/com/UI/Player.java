package com.UI;

public class Player {
    public OurColor color;
    public Piece[] pieces;
    public Player(OurColor color)
    {
        color = this.color;

    }
    public boolean IsWinner(){
        for (int i = 0; i < pieces.length ; i++) {
            if(!pieces[i].IsFinish()){
                //At least one piece is not in the finish position
                return false;
            }
        }
        //All pieces are in the Finish
        return true;
    }
    public boolean AnyPiecesHome(){

        for (int i = 0; i < pieces.length ; i++) {
            if(!pieces[i].IsHome()){
                //At least one piece is in the home position
                return true;
            }
        }
        //No available pieces to move out of home
        return false;
    }


}
