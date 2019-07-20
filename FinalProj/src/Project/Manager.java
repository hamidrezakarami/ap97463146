package Project;

import java.util.ArrayList;

public class Manager {
    private String name;
    private String surname;
    private String password;
    //ToDo : privet or public ??????????????



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



    public String saveToFile (){
        return name + "_" + password;
    }
}
