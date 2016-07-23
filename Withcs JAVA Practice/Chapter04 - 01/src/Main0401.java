import java.util.*;

public class Main0401 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double s, r, area;
        int round;

        r = sc.nextDouble();
        s = 2*r*Math.sin(3.1415926/5);

        area = (5*s*s)/(4*Math.tan(3.1415926/5));

        round = (int)Math.round(area*100);
        area = (double)round/100;

        System.out.println(area);
    }
}
