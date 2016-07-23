import java.util.*;

public class Main0306 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();
        double a = y1 - y2;
        double b = -(x1 - x2);
        double c = y3 - y4;
        double d = -(x3 - x4);
        double e = a * x1 + b * y1;
        double f = c * x3 + d * y3;

        if(a/c == b/d) {
            System.out.print("parallel");
        }
        else {
            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - e * c) / (a * d - b * c);

            System.out.printf("%f", x);

            System.out.print(" ");

            System.out.printf("%f\n",y);

            int aa = (int)(x * 10);
            x = (double) aa / 10;


            int bb = (int)(y * 10);
            y = (double) bb / 10;


            System.out.printf("%.1f", x);

            System.out.print(" ");

            System.out.printf("%.1f",y);
        }
    }
}