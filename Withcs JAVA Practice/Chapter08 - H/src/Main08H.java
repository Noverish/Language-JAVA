import java.util.*;

public class Main08H {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int input;
        char player = 'R';
        int[][] board = new int[6][7];
        int[] height = new int[7];

        for(int i = 0;i<7;i++)
            height[i] = 5;

        for(int i = 0;i<6;i++)
            for(int j = 0;j<7;j++)
                board[i][j] = ' ';


        while(true) {
            input = sc.nextInt();

            board[height[input]--][input] = player;

            if(dummy(board))
                break;

            if(player == 'R')
                player = 'Y';
            else
                player = 'R';
        }

        for(int i = 0;i<6;i++) {
            for (int j = 0; j < 7; j++)
                System.out.printf("%c",board[i][j]);
            System.out.print("\n");
        }

    }

    public static boolean dummy(int[][] board) {
        Scanner sc = new Scanner(System.in);

        int row = 6;
        int col = 7;
        int ans = 0;

        int[][] array = new int[row+8][col+8];

        for(int i = 0;i<row+8;i++)
            for(int j = 0;j<col+8;j++)
                array[i][j] = ' ';

        for(int i = 4;i<row+4;i++)
            for(int j = 4;j<col+4;j++)
                array[i][j] = board[i-4][j-4];


        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i][j+1])
                    if(array[i][j+1] == array[i][j+2] && array[i][j+1]!=' ')
                        if(array[i][j+2] == array[i][j+3])
                            ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i+1][j])
                    if(array[i+1][j] == array[i+2][j] && array[i+1][j]!=' ')
                        if(array[i+2][j] == array[i+3][j])
                            ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i+1][j+1])
                    if(array[i+1][j+1] == array[i+2][j+2] && array[i+1][j+1]!=' ')
                        if(array[i+2][j+2] == array[i+3][j+3])
                            ans++;
            }

        for(int i = 4;i<row + 4;i++)
            for(int j = 4;j<col + 4;j++){
                if(array[i][j] == array[i-1][j+1])
                    if(array[i-1][j+1] == array[i-2][j+2] && array[i-1][j+1]!=' ')
                        if(array[i-2][j+2] == array[i-3][j+3])
                            ans++;
            }

        if(ans>0)
            return true;
        else
            return false;
    }
}
