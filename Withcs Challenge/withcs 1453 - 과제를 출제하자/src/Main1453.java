import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main1453 {
    private static int[][] map = new int[2001][2001];

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        int n, i, j;
        int[] weight = new int[2001];

        n = sc.nextInt();
        for (i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        for (i = 1; i <= n; i++) {
            map[i][0] = weight[i - 1] * i + map[i - 1][0];
            map[0][i] = weight[n - i] * i + map[0][i - 1];
        }

        print(n, weight);

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                if (map[i - 1][j] + weight[i - 1] * (i + j) > map[i][j - 1] + weight[n - j] * (i + j))
                    map[i][j] = map[i - 1][j] + weight[i - 1] * (i + j);
                else map[i][j] = map[i][j - 1] + weight[n - j] * (i + j);
            }
        }

        print(n, weight);

        int max = 0;

        for (i = 0; i <= n; i++) {
            if (max < map[i][n - i])
                max = map[i][n - i];

        }
        System.out.printf("%d\n", max);
    }

    private static void print(int n, int[] weight) {
        for(int i = 0;i<=n;i++) {
            for(int j = 0;j<=n;j++) {
                System.out.printf("%3d",map[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0;i<=n;i++) {
            System.out.printf("%3d",weight[i]);
        }

        System.out.println("\n");
    }
}
