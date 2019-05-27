

import javafx.scene.control.TextField;

public class Patient {
    private String name;
    private String family;
    private int id;    ////////for find patient
    private int roomnumber;
    private boolean pay = false;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPay(){
        pay = true;
        return pay;
    }
    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }
    @Override
    public String toString() {
        return getName() +"\t\t"+ getFamily() +"\t\t"+ getId() + "\t\t";
    }


    public String saveToFile () {
        return "_" + getRoomnumber()+ "_" + getName() + "_" + getFamily() + "_" + getId();
    }


}
