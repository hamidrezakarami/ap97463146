package Project;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String password;
    private long studentid;

    ArrayList<Corse> corses = new ArrayList<>();

    public Student (String name,String surname,String password,long studentid){
        this.name =name;
        this.surname = surname;
        this.password = password;
        this.studentid = studentid;
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

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return name+"\t\t"+surname+"\t\t"+studentid;
    }

    public String saveToFile (){
        return "0_" + name + "_" + surname +"_" + password+"_" + studentid ;
    }
}
