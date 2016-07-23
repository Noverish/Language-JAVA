import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double x1, x2, x3, y1, y2, y3, s;
        double side1, side2, side3;
        double area;
        long areaInt;

        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        x3 = sc.nextDouble();
        y3 = sc.nextDouble();

        side1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        side2 = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
        side3 = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
        s = (side1 + side2 + side3)/2;
        area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));

        areaInt = (long)Math.floor(area*10);
        area = (double)areaInt/10;

        System.out.printf("%.1f",area);
    }
}