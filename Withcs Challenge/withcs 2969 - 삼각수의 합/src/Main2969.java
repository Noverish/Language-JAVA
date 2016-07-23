import java.util.*;

public class Main2969 {
    public static long[] index = new long[301];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        fillIndex();

        int testCase = sc.nextInt();

        for(int i = 1;i<=testCase;i++) {
            int n = sc.nextInt();

            System.out.println(i + " " + n + " " + W(n));
        }
    }

    public static void fillIndex() {
        for(int n = 1;n<=300;n++)
            index[n] = W(n);
    }

    public static long W(int n) {
        long sum = 0;
        for(int k = 1;k<=n;k++)
            sum += k*(k+2)*(k+1)/2;
        return sum;
    }
}