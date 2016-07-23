import java.util.*;

public class Main08B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[3][3];
        int[][] b = new int[3][3];
        int[][] c = new int[3][3];

        for(int i = 0;i<3;i++)
            for(int j = 0;j<3;j++)
                a[i][j] = sc.nextInt();

        for(int i = 0;i<3;i++)
            for(int j = 0;j<3;j++)
                b[i][j] = sc.nextInt();

        for(int i = 0;i<3;i++)
            for(int j = 0;j<3;j++)
                c[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j] + a[i][2]*b[2][j];

        for(int i = 0;i<3;i++)
            for(int j = 0;j<3;j++) {
                System.out.print(c[i][j]);

                if(j==2)
                    System.out.print("\n");
                else
                    System.out.print(" ");
            }

    }
}
