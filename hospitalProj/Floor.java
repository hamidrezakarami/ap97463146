

import java.util.ArrayList;

public class Floor {
    private int floornum;

//    ArrayList<Emergency> eroom =new ArrayList<Emergency>();
//    ArrayList<Streise> sroom =new ArrayList<Streise>();
//    ArrayList<IntensiveCare> icuroom =new ArrayList<IntensiveCare>();



    Emergency[] eroom = new Emergency[6];
    Streise[] sroom = new Streise[3];
    IntensiveCare[] icuroom = new IntensiveCare[3];


    public int getFloornum() {
        return floornum;
    }

    public void setFloornum(int floornum) {
        this.floornum = floornum;
    }
}
