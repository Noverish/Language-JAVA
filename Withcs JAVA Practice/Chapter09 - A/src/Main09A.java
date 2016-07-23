import java.util.*;

public class Main09A {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        double w1, h1;
        w1 = sc.nextDouble();
        h1 = sc.nextDouble();

        Rectangle r1 = new Rectangle();
        r1.width = w1;
        r1.height = h1;
        System.out.printf("%.2f\n", r1.getArea());

        Rectangle r2 = new Rectangle(w1, h1);
        System.out.printf("%.2f\n", r2.getPerimeter());
    }
}
