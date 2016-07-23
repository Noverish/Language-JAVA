import java.util.*;

public class Main0508 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int number;

        for(;testCase>0;testCase--) {
            number = sc.nextInt();
            number++;

            int iint;
            iint = (int)Math.floor(pi(number)*10000);

            System.out.printf("%.4f\n",(double)iint/10000);
        }


    }

    public static double pi(int i) {
        double ans = 0;

        for(int j = 1 ; j<=i-1 ; j++){

            double up = Math.pow((double)-1,(double)(j+1));
            double down = 2*j-1;

            ans += up/down;
        }

        return ans*4;
    }
}
