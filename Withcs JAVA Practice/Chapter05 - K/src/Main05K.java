import java.util.*;

public class Main05K {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[1005];
        int testCase = sc.nextInt();
        int ansNum = 0, ansCase = 0;

        for(int i = 0;i < testCase;i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num, 0, testCase - 1);

        for(int i = 0;i < testCase-1;i++) {
            int cases = 0;
            int number = 0;

            while(true) {
                if(num[i]==num[i+1]) {
                    number = num[i];
                    cases++;
                    i++;
                }
                else {
                    if(cases > ansCase) {
                        ansCase = cases;
                        ansNum = number;
                    }
                    else {
                        cases = 0;
                        number = 0;
                    }
                    break;
                }
            }
        }

        System.out.println(ansNum);
        System.out.println(ansCase+1);
    }
}
