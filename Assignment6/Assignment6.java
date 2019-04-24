package Assignment6;
import java.util.*;
public class Assignment6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter a number:");
        int n = sc.nextInt();

        ArrayList <Integer> list = new ArrayList<>(n);
        ArrayList<ArrayList<Integer>> twoDimentionArray = new ArrayList<ArrayList<Integer>>();

        int random = rand.nextInt(n);
        System.out.println("random is"+random + "\n");

        for (int i = 0 ; i < random ; i++) {
            for (int j = rand.nextInt(n) ; j>0;j--) {
                list.add((rand.nextInt(n-1))+1);
            }
            twoDimentionArray.add(list);
            list = new ArrayList<>();
        }

        for (int i = 0; i < twoDimentionArray.size() ; i++){
            System.out.println(twoDimentionArray.get(i) + "\n");
        }
    }
}
