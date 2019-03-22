package assignment1;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        for (int i =1 ; i <= 2*n ; i+=2){
            for (int j = 0 ; j < Math.abs(n-i)/2 ; j++){
                System.out.print(" ");
            }
            for ( int j=0;j < n - Math.abs(n - i) ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
