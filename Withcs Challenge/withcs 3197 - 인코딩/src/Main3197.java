import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main3197 {
    public static int nowRow = 0;
    public static int nowCol = 0;
    public static int directino = 0;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        int testCase = sc.nextInt();

        for(int count = 1;count<=testCase;count++) {

            directino = nowRow = nowCol = 0;

            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean filled = false;
            int[][] chart = new int[row][col];
            boolean[][] copyChart = new boolean[row][col];
            int[] binary = new int[5];
            char[] str = new char[row*col/5 + 1];

            for(int i = 0;i<row;i++)
                for(int j = 0;j<col;j++)
                    copyChart[i][j] = true;

            String tmp = sc.nextLine();
            for(int i = 0;i<tmp.length()-1;i++) {
                str[i] = tmp.charAt(i + 1);
                charintoBinary(str[i],binary);
                filled = pushBinary(binary, chart, copyChart, row, col);

                if(filled)
                    break;
            }

            System.out.print(count + " ");

            for(int i = 0;i<row;i++)
                for (int j = 0; j < col; j++)
                    System.out.print(chart[i][j]);

            System.out.println();

        }
    }

    public static void charintoBinary(char ch, int[] binary) {
        if(ch==' ')
            Arrays.fill(binary, 0);
        else {
            if('a' <= ch && ch <= 'z')
                ch = (char)(ch - 'a' + 'A');

            int value = ch-'A'+1;

            for(int i = 4;i>=0;i--) {
                if(value%2==1) {
                    binary[i] = 1;
                    value/=2;
                }
                else {
                    binary[i] = 0;
                    value/=2;
                }
            }


        }
    }

    public static boolean pushBinary(int[] binary, int[][] chart, boolean[][] copyChart, int row, int col) {
        for(int i = 0;i<5;i++) {

            if(!copyChart[nowRow][nowCol])
                return true;

            chart[nowRow][nowCol] = binary[i];
            copyChart[nowRow][nowCol] = false;
            switch (directino) {
                case 0 : {
                    if(nowCol+1 == col) {
                        directino = 1;
                        nowRow++;
                        break;
                    }
                    else if(!copyChart[nowRow][nowCol+1]) {
                        directino = 1;
                        nowRow++;
                    }
                    else {
                        nowCol++;
                    }
                    break;
                }
                case 1 : {
                    if(nowRow+1 == row) {
                        directino = 2;
                        nowCol--;
                        break;
                    }
                    else if(!copyChart[nowRow+1][nowCol]) {
                        directino = 2;
                        nowCol--;
                    }
                    else {
                        nowRow++;
                    }
                    break;
                }
                case 2 : {
                    if(nowCol -1 == -1) {
                        directino = 3;
                        nowRow--;
                        break;
                    }
                    else if(!copyChart[nowRow][nowCol-1]) {
                        directino = 3;
                        nowRow--;
                    }
                    else {
                        nowCol--;
                    }
                    break;
                }
                case 3 : {
                    if(nowRow-1 == -1) {
                        directino = 0;
                        nowCol++;
                        break;
                    }
                    else if(!copyChart[nowRow-1][nowCol]) {
                        directino = 0;
                        nowCol++;
                    }
                    else {
                        nowRow--;
                    }
                    break;
                }
            }

            /*print(chart, copyChart,row,col);

            int a = 0;*/
        }



        return false;
    }

    public static void print(int[][] chart, boolean[][] copyChart, int row, int col) {

        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++)
                System.out.print(chart[i][j] + " ");

            /*for(int j = 0;j<col;j++)
                if(copyChart[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");*/

            System.out.println();
        }

        System.out.println();

    }
}
