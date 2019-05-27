

        import java.util.ArrayList;

public abstract class Room {
    private int roomid;
    private int floorid;
    private int sizaofroom =0 ;


    ArrayList<Bed> beds = new ArrayList<Bed>();


    abstract boolean isEmpty ();


    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getFloorid() {
        return floorid;
    }

    public void setFloorid(int floorid) {
        this.floorid = floorid;
    }

    public int getSizaofroom() {
        return sizaofroom;
    }

    public void setSizaofroom(int sizaofroom) {
        this.sizaofroom = sizaofroom;
    }
}
