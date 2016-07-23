import java.util.Scanner;

public class Main4316 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0;i<testCase;i++) {
            int tmp = sc.nextInt();

            System.out.println(zeros_in_range(1,tmp));
        }
    }

    public static long Z(long n)
    {
        if (n == 0) {
            return 0;
        }
        if (n <= 10) {
            return 1;
        }
        long k = n/10, r = n%10;
        long zeros = k + 10*(Z(k)-1);
        if (r > 0) {
            zeros += r*zeroCount(k) + 1;
        }
        return zeros;
    }

    public static long zeroCount(long k)
    {
        long zeros = 0;
        while(k!=0) {
            if((k % 10) == 0)
                zeros += 1;
            k /= 10;
        }
        return zeros;
    }

    public static long zeros_in_range(long low, long high)
    {
        return Z(high+1) - Z(low); // beware of overflow if high is ULLONG_MAX
    }
}
