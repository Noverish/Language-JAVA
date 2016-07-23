import java.util.*;

public class Main0403 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double s, area;
        int n;
        long number;

        n = sc.nextInt();
        s = sc.nextDouble();

        area = (n*s*s)/((double)4*Math.tan(Math.PI/(double)n));

        number = (long)Math.floor(area*100);
        area = (double)number/100;

        System.out.printf("%.2f",area);

    }
}
