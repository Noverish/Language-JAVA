import java.util.*;

public class Main0502 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase;
        int num1, num2;
        int ans = -1;

        testCase = sc.nextInt();

        for(int j = 0; j<testCase;j++) {

            num1 = sc.nextInt();
            num2 = sc.nextInt();

            if(num1 > num2) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp;
            }

            for (int i = 1; i <= num1; i++) {
                if((num1%i) == 0 && (num2%i) == 0) {
                    ans = i;
                }
            }

            System.out.println(ans);
        }

    }
}
