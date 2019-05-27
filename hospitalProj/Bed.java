
public class Bed {
    private int bedid;
    private int roomid;
    private boolean isempty = true;
    Patient patient = new Patient();


    public void getPatient(String name, String family, int id,int roomnumber) {
        patient.setName(name);
        patient.setFamily(family);
        patient.setId(id);
        patient.setRoomnumber(roomnumber);
    }


    public boolean isEmpty() {
        if (isempty) {
            isempty = false;
            return true;
        } else
            return false;
    }

    public int getBedid() {
        return bedid;
    }

    public void setBedid(int bedid) {
        this.bedid = bedid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public boolean isIsempty() {
        return isempty;
    }

    public void setIsempty(boolean isempty) {
        this.isempty = isempty;
    }


}
