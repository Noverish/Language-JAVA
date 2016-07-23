import java.util.*;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        double x, y;

        x = sc.nextDouble();
        y = sc.nextDouble();

        if(x < -5 || x > 5) {
            System.out.println("out");
        }
        else if(x == -5 || x == 5) {
            if(y > 2.5 || y < -2.5) {
                System.out.println("out");
            }
            else {
                System.out.println("on");
            }
        }
        else {
            if(y > 2.5 || y < -2.5) {
                System.out.println("out");
            }
            else if(y == 2.5 || y == -2.5) {
                System.out.println("on");
            }
            else {
                System.out.println("in");
            }
        }
    }
}
