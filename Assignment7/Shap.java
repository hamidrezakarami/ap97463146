package Assignment7;
import java.util.Random;
public abstract class Shap {
    double side1,side2,perimeter,area;
    String shapname;
    Random rand = new Random();


    public void Perimeter (double side1,double side2){
    }

    public void Area (double side1,double side2){
    }
    public String name (){
        return shapname;

    }

    public double SetRandomSide() {
        return  perimeter;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getArea() {
        return area;
    }
}
