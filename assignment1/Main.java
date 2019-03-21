package assignment1;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Print p = new Print();
        int n = 1;
        boolean flag = false;

        while (flag == false){
            System.out.println("Please enter ood number:");//TODO : chek ood and even
            n = sc.nextInt();
            flag = p.contorol(n);
        }
        p.stare( n);
    }
}
