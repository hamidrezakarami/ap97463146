public class Studying  extends Student {
    private int vahed ;

    @Override
    public void set(int vahed) {
        this.vahed = vahed;
    }

    @Override
    public boolean check(int unit) {

        if (vahed <= 250)
            return true;
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
        System.out.println("Enter units passed:");
        this.vahed = sc.nextInt();
        if(check(vahed)){
            System.out.println("Student Successfully saved");
            setIstrue(true);
        }
        else{
            System.out.println("Error\n units most be less than 250!!!!!!");
            setIstrue(false);
        }
    }

    @Override
    public String sendToFile() {
        String s ="1_" + getName() + "_" +getFname() + "_" + getStudentid() + "_" + getEntering_year()+ "_" + vahed;
        return s ;
    }

    @Override
    public String toString() {
        return "name :"+getName()+"\nFamili name :"+getFname()+"\nStudentID :"+getStudentid()+"\nEntering year :"+getEntering_year()+"\nUnit passed :"+vahed+"\n\n";
    }
}
