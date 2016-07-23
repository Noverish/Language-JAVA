import java.util.Scanner;

public class Main0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x_bit = new int[32];
        int x = sc.nextInt(), p = sc.nextInt(), n = sc.nextInt();
        int i, j;

        for (i = 0; x != 0; i++) {
            x_bit[i] = x % 2;
            x /= 2;
        }

        i = p;
        j = n;
        for (; i <= p + n - 1; i++) {
            if (x_bit[i] == 0) x_bit[i] = 1;
            else x_bit[i] = 0;
        }
        for (j = 0; j < 32; j++) {
            System.out.printf("%d", x_bit[j]);
        }
    }
}