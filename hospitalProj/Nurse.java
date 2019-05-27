public class Nurse extends Personnel {

    public Nurse (String name,String family,String address,int id){
        setName( name );
        setFamily(family);
        setAddress(address);
        setId(id);
    }



    @Override
    public String toString() {
         return "Nurse :"+ getName() +"\t\t"+ getFamily() +"\t\t"+getAddress() +"\t\t"+ getId() + "\t\t";
    }


    public String saveToFile () {
        return "2_" + getName() + "_" + getFamily() + "_" + getAddress() + "_" + getId();
    }
}
