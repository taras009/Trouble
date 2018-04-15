package com.UI;

public class Board {
    public PopOMatic die;
    public Player[] players;
    public int[] spaces;

    //   0-27 = board space
    //28-31 = red home  32-35 =green home 36-39=yellow home 40-43= blue home
    // 44-47= red finish 48-51= green finish 52-55= yellow finish 56-59 = blue finish
    Board(){
        System.out.println("Board ka constructor");
        die = new PopOMatic();
        players = new Player[4];
        players[0]= new Player(OurColor.RED);
        players[1]= new Player(OurColor.GREEN);
        players[2]= new Player(OurColor.YELLOW);
        players[3]= new Player(OurColor.BLUE);
        spaces = new int[60];
    }
//public boolean AnyWinners(){
//    for (int i = 0; i < players.length; i++) {
//        if(players[i].IsWinner()){
//            return true;
//        }
//    }
//    return false;
//}


}
