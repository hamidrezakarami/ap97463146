


public class Streise extends Room {


    @Override
    public boolean isEmpty() {
        if(getSizaofroom()<1) {
            setSizaofroom(getSizaofroom()+1);
            return true;
        }
        else
            return false;
    }
}
