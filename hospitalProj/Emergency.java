
public class Emergency extends Room {


    @Override
    public boolean isEmpty() {
        if (getSizaofroom() < 4) {
            setSizaofroom(getSizaofroom() + 1);
            return true;
        } else
            return false;
    }
}
