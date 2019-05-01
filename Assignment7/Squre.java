package Assignment7;

public class Squre extends Shap {


    @Override
    public void Perimeter(double side1, double side2) {
        perimeter = side1 * 2;
    }

    @Override
    public void Area(double side1, double side2) {
        area = side1 * side1;
    }

    @Override
    public double SetRandomSide() {
        side1 = rand.nextInt(1000) / 10;
        Perimeter(side1, side2);
        Area(side1, side2);
        return perimeter;
    }

    @Override
    public String name() {
        shapname = "Squre";
        return shapname;
    }

}
