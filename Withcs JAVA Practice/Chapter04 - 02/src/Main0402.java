import java.util.*;

public class Main0402 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double d, radius, x1, x2, y1, y2;
        long number;

        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();

        x1 = x1*3.1415926/180;
        y1 = y1*3.1415926/180;
        x2 = x2*3.1415926/180;
        y2 = y2*3.1415926/180;

        radius = 6371.01;

        double tmp = Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2);

        d = radius * Math.acos(tmp);

        number = (long)Math.round(d*100);
        d = (double)number/100;

        System.out.println(d);

    }
}
