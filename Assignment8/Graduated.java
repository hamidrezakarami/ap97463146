public class Graduated extends Student {

    private int graduated_year;


    @Override
    public void set(int graduated_year) {
        this.graduated_year = graduated_year;
    }

    @Override
    public boolean check(int graduated_year) {
        if(graduated_year >= 1380){
            return true;
        }
        else
            return false;

    }

    @Override
    public void enterData() {
        System.out.println("Enter student name:");
        this.setName(sc.next());
        System.out.println("Enter student family name:");
        this.setFname(sc.next());
        System.out.println("Enter studentid:");
        this.setStudentid(sc.nextLong());
        System.out.println("Enter student entering year :");
        this.setEntering_year(sc.nextInt());
        System.out.println("Enter graduated year:");
        this.graduated_year = sc.nextInt();
        if(check(graduated_year)){
            System.out.println("Student Successfully saved");
            setIstrue(true);
        }
        else{
            setIstrue(false);
            System.out.println("Error\ngraduated year must be more than 1380!!!!!!");
        }

    }
    @Override
    public String sendToFile() {
       String s ="0_" + getName() + "_" +getFname() + "_" + getStudentid() + "_" + getEntering_year()+ "_" + graduated_year;
       return s;
    }

    @Override
    public String toString() {
        return "name :"+getName()+"\nFamili name :"+getFname()+"\nStudentID :"+getStudentid()+"\nEntering year :"+getEntering_year()+"\nGraduated year :"+graduated_year+"\n\n";
    }
}
