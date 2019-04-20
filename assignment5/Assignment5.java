public class Assignment5 {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        double f;
        double max = 0;
        double min = 100;
        for (int x = 1000; x >= (-1000); x--) {
            for (int y = x; y >= (-1000); y--) {
                f = Math.sqrt((x * x) + (y * y)) / ((x * Math.sin(x + y)) + (y * Math.cos(x + y)));
                if (f > max) {
                    max = f;
                }
                if (f < min){
                   min = f;
                }
            }
        }
        System.out.println("max is :"+ max + "  and min is:  " + min);
        System.out.println((System.currentTimeMillis() - startTime) + " ms");


    }
}


