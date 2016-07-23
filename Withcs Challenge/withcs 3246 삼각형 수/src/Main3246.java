import java.util.Scanner;

public class Main3246 {
    private static int s[][] = new int[401][801];
    private static int max_sum;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int cnum = 0;true;) {
            n = sc.nextInt();

            if(n == 0)
                break;

            max_sum = -2000000000;

            for (int i = 0, l; i < n; ++i) {
                l = (i*2) + 1;
                for (int j = 1; j <= l; ++j) {
                    s[i][j] = sc.nextInt();
                    s[i][j] += s[i][j - 1];
                }
            }

            for (int i = 0, l; i < n; ++i) {
                l = (i << 1) + 1;
                for (int j = 1; j <= l; ++j)
                    test_sum(i, j, j, 0);
            }

            System.out.printf("%d. %d\n", ++cnum, max_sum);
        }
    }

    private static void test_sum(int line, int left, int right, int sum) {
        if (line < 0 || line >= n)
            return;
        if (left <= 0 || right > 1 + (line*2))
            return;

        sum += s[line][right] - s[line][left - 1];

        if (sum > max_sum)
            max_sum = sum;
        if ((left & 1) == 0)
            test_sum(line - 1, left - 2, right, sum);
        else
            test_sum(line + 1, left, right + 2, sum);
    }
}
