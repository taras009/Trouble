package com.UI;

public class Piece {
    public int Location;

    public boolean IsHome() {
        if (this.Location < 44 && this.Location > 27)
            return true;
        else
            return false;
    }

    public boolean IsFinish() {
        if (this.Location > 43)
            return true;
        else
            return false;
    }

    public boolean CompletedLoop() {
        return false;
    }

}
