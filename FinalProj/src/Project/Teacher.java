package Project;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private String surname;
    private String password;
    private long personnleid;
    ArrayList<Corse> corses = new ArrayList<>();


    public Teacher (String name,String surname,String password,long personnleid){
        this.name =name;
        this.surname = surname;
        this.password = password;
        this.personnleid = personnleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPersonnleid() {
        return personnleid;
    }

    public void setPersonnleid(long personnleid) {
        this.personnleid = personnleid;
    }

    public String saveToFile (){
        return "1_" + name +"_"+surname+"_"+password+"_"+personnleid;
    }
}
