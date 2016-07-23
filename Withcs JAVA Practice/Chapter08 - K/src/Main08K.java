import java.util.*;

public class Main08K {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = row;
        int[][] array = new int[row][col];
        int[][] copy = new int[row][col];
        int ansi = -1, ansj = -1, ansk = 0;

        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++)
                array[i][j] = sc.nextInt();

        for(int i = 0; i < row; i++)
            copy[i][0] = array[i][0];

        for(int j = 0; j < col; j++)
            copy[0][j] = array[0][j];

        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(array[i][j] == 1)
                    copy[i][j] = min(copy[i][j-1], copy[i-1][j], copy[i-1][j-1]) + 1;
                else
                    copy[i][j] = 0;
            }
        }

        ansk = copy[0][0];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(ansk < copy[i][j])
                {
                    ansk = copy[i][j];
                    ansi = i;
                    ansj = j;
                }
            }
        }

        System.out.println((ansi-ansk+1) + " " + (ansj-ansk+1) + " " + ansk);
    }




    public static int min(int a, int b, int c) {
        int[] asdf = new int[3];
        asdf[0] = a;
        asdf[1] = b;
        asdf[2] = c;
        Arrays.sort(asdf);
        return asdf[0];
    }


}
