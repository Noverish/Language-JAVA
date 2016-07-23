import java.util.*;

public class Main0307 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double x, y;

        x = sc.nextDouble();
        y = sc.nextDouble();

        if(x<0 || x>200) {
            System.out.print("out");
        }
        else if(x==0) {
            if(y>100 || y<0)
                System.out.print("out");
            else
                System.out.print("on");
        }
        else if(x==200) {
            if(y==0)
                System.out.print("on");
            else
                System.out.print("out");
        }
        else {
            if(y<0)
                System.out.print("out");
            else if(y > (-0.5)*x + 100)
                System.out.print("out");
            else if(y == (-0.5)*x + 100)
                System.out.print("on");
            else if(y < (-0.5)*x + 100)
                System.out.print("in");
        }
    }
}
