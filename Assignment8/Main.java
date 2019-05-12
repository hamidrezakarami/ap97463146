
import java.util.*;
public  class Main {


    public static void main(String[] args) throws Exception {
        ArrayList<Student> st = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        FileClass f = new FileClass();

        f.creatFile();
        f.read();
        st = f.read();


        boolean istrue = true;
        int chk;

        for (int i = st.size(); istrue; i++) {
            System.out.println("if you want to add graduated student enter \"0\" or studing student \"1\" or want to Exit enter other number:");
            chk = sc.nextInt();
            if (chk == 0) {
                st.add(new Graduated());
                st.get(i).enterData();

                if (st.get(i).getIstrue() == false) {
                    st.remove(i);
                    i--;
                }

            }



            else if (chk == 1) {
                st.add(new Studying());
                st.get(i).enterData();


                if (st.get(i).getIstrue() == false) {
                    st.remove(i);
                    i--;
                }

            } else
                break;

        }


        st.sort(Student::compareTo);


        f.saveToFile(st);
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i).toString());
        }




    }



}


