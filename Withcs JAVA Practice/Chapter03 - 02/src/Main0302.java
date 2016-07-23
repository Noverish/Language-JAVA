import java.util.*;

public class Main0302 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double a,b,c,d,e,f;
        double x, y;
        long xLong, yLong;

        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        e = sc.nextDouble();
        f = sc.nextDouble();

        if ((a * d - b * c) == 0) {
            System.out.println("no solution");
        }
        else {

            x = (e * d - b * f) / (a * d - b * c);
            y = (a * f - e * c) / (a * d - b * c);

            if (x < y) {
                double trash;
                trash = x;
                x = y;
                y = trash;
            }

            xLong = (long)Math.floor(x);
            yLong = (long)Math.floor(y);

            System.out.println(xLong + " " + yLong);
        }
    }
}
