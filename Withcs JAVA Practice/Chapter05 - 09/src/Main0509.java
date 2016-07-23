import java.util.*;

public class Main0509 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int number;

        for(;testCase>0;testCase--) {
            number = sc.nextInt();

            int iint;
            iint = (int)Math.floor(ee(number)*1000000);

            System.out.printf("%.6f\n",(double)iint/1000000);
        }


    }

    public static double ee(int i) {
        double ans = 0;

        for(int j = 0 ; j<=i ; j++){
            ans += 1/pac(j);
        }

        return ans;
    }

    public static double pac(int num) {

        double ans = 1;

        if(num == 0)
            return 1.0;
        else if(num ==1)
            return 1.0;
        else{
            for(int i = 1;i <= num;i++)
                ans*=i;

            return ans;
        }
    }
}
