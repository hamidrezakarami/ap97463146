import java.util.*;


public class Assignment3 {




    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("pleas inter number for matrix:");
        n = sc.nextInt();
        int [][] m = new int[n][n];

        //for set random number
        for( int j=0 ; j<n ; j++){
            for(int i=0 ; i<n ; i++){
                m[i][j]=rand.nextInt(100);
            }
        }

        //for print matrix
        for( int j=0 ; j<n ; j++){
            for(int i=0 ; i<n ; i++){
                System.out.printf("%4d",m[i][j]);
            }
            System.out.println();
        }

        //for print number
        --n;
        System.out.println("\n");
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 , h = i ; h >= 0 ; j++ , h--){
                System.out.printf("%4d",m[h][j]);
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int h = n , j = i ; j <=n ; h-- , j++){
                System.out.printf("%4d",m[h][j]);
            }
        }

    }


}
