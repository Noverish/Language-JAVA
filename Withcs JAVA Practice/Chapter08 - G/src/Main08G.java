import java.util.*;

public class Main08G {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] array = new int[row+8][col+8];
        int ans = 0;

        for(int i = 0;i<row + 8;i++)
            for(int j = 0;j<col + 8;j++)
                array[i][j] = -1;

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++)
                array[i][j] = sc.nextInt();


        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i][j+1])
                    if(array[i][j+1] == array[i][j+2])
                        if(array[i][j+2] == array[i][j+3])
                                ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i+1][j])
                    if(array[i+1][j] == array[i+2][j])
                        if(array[i+2][j] == array[i+3][j])
                                ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i+1][j+1])
                    if(array[i+1][j+1] == array[i+2][j+2])
                        if(array[i+2][j+2] == array[i+3][j+3])
                                ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i-1][j+1])
                    if(array[i-1][j+1] == array[i-2][j+2])
                        if(array[i-2][j+2] == array[i-3][j+3])
                                ans++;
            }

        System.out.println(ans);

    }
}
