package Assignment7;
import java.util.ArrayList;
import java.util.Random;
public class Main {


    public static <e> void main(String[] args) {

        Random rand = new Random();

        int shap = rand.nextInt(3);
        double[] per = new double[10];
        String[] name = new String[10];
        double[][] side = new double[10][2];
        double[] area = new double[10];



        for (int i = 0; i < 10; i++) {
            if (shap == 0) {                       //Circle
                Circle c = new Circle();
                per[i] = c.SetRandomSide();
                name[i] = c.name();
                side[i][0] = c.getSide1();
                area[i] = c.getArea();
            } else if (shap == 1) {                //squre
                Squre s = new Squre();
                per[i] = s.SetRandomSide();
                name[i] = s.name();
                side[i][0] = s.getSide1();
                area[i] = s.getArea();
            } else {                               //rectangle
                Rectangle r = new Rectangle();
                per[i] = r.SetRandomSide();
                name[i] = r.name();
                side[i][0] = r.getSide1();
                side[i][1] = r.getSide2();
                area[i] = r.getArea();
            }
            shap = rand.nextInt(3);
        }

for (int h=0 ;h<9;h++) {
    for (int i = h; i < 9; i++) {
        if (per[i] > per[i + 1]) {
            double tempper = per[i];
            per[i] = per[i + 1];
            per[i + 1] = tempper;
            String tempname = name[i];
            name[i] = name[i + 1];
            name[i + 1] = tempname;
            double temparea = area[i];
            area[i] = area[i + 1];
            area[i + 1] = temparea;
            for (int j = 0; j < 2; j++) {
                double tempside = side[i][j];
                side[i][j] = side[i + 1][j];
                side[i + 1][j] = tempside;
            }
        }
    }
}
for (int i = 0 ; i < 10 ;i++ ){
    if (side[i][1] == 0) {
        System.out.println(name[i] + "\tside = " + side[i][0] + "\tPerimeter = " + per[i] + "\tArea =" + area[i]);
    }
    else{
        System.out.println(name[i] + "\t  side1 = " + side[i][0] +"\tside2 =" +side[i][1] + "\tPerimeter = " + per[i] + "\tArea =" + area[i]);
    }

    }

    }

}
