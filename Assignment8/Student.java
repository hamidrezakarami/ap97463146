import java.util.Scanner;

public abstract class Student implements Comparable<Student> {
    private String name;
    private String fname;
    private long studentid;
    private int entering_year;

    private boolean istrue ;

    Scanner sc = new Scanner(System.in);


    abstract public void set (int a);
    abstract public boolean check (int a);
    abstract public void enterData ();
    abstract public String sendToFile ();
    abstract public String toString();


    public final int compareTo(Student o) {
        return ((Long)this.getStudentid()).compareTo(o.getStudentid());
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public long getStudentid() {
        return studentid;
    }
    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }
    public int getEntering_year() {
        return entering_year;
    }
    public void setEntering_year(int entering_year) {
        this.entering_year = entering_year;
    }

    public boolean getIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }
}
