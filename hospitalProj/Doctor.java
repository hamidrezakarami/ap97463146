public class Doctor extends Personnel {

    public Doctor (String name,String family,String address,int id){
        setName( name );
        setFamily(family);
        setAddress(address);
        setId(id);
    }


    @Override
    public String toString() {
        return "Doctor :"+ getName() +"\t\t"+ getFamily() +"\t\t"+getAddress() +"\t\t"+ getId() + "\t\t";
    }


    public String saveToFile () {
        return "1_" + getName() + "_" + getFamily() + "_" + getAddress() + "_" + getId();
    }
}
