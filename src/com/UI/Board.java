package com.UI;

public class Board {
    public PopOMatic die;
    public Player[] players;
    public int[] spaces;
    //0-3 = red home  4-7 =green home 7-11=yellow home 12-15= blue home
    //   16-43 = board space
    // 44-47= red finish 48-51= green finish 52-55= yellow finish 56-59 = blue finish
    Board(){
        die = new PopOMatic();
        players = new Player[4];
        players[0]= new Player(OurColor.RED);
        players[1]= new Player(OurColor.GREEN);
        players[2]= new Player(OurColor.YELLOW);
        players[3]= new Player(OurColor.BLUE);
        spaces = new int[60];
    }
}
