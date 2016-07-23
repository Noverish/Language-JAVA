import java.util.*;

public class Main0309 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double x1, x2, x3, y1, y2, y3;
        double slope;

        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        x3 = sc.nextDouble();
        y3 = sc.nextDouble();


            slope = (x2 - x1)*(y3 - y1) - (x3 - x1)*(y2 - y1);

            if(slope>0)
                System.out.print("left");
            else if(slope==0)
                System.out.print("on the line");
            else if(slope<0)
                System.out.print("right");



    }
}
