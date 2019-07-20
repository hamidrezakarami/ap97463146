package Project;

import java.util.ArrayList;

public class Corse {
    private int classnum;
    private String name;
    private int courseid;
    private String information;
    ArrayList<Float> score = new ArrayList<>() ;
    Teacher teacher;
    ArrayList<Student> studentlist = new ArrayList<>();
    public Corse (int classnum , String name , Teacher teacher,int courseid,String information){
        this.teacher = teacher;
        this.name = name;
        this.classnum = classnum;
        this.courseid = courseid;
        this.information = information;
    }

    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return courseid +"\t\t"+ name +"\t\t"+ classnum +"\t\t"+ teacher.getName()+"\t\t"+information;
    }


    public String saveToFile (){
        return "2_"+classnum+"_"+name+"_"+courseid+"_"+information+"_"+score;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    public void setTeacher (Teacher t){
        this.teacher = t;
    }
}
