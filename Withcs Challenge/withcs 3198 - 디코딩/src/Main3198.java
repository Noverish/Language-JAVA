import java.io.*;
import java.util.*;

public class Main3198 {
    public static int nowRow = 0;
    public static int nowCol = 0;
    public static int direction = 0;
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        int testCase = sc.nextInt();

        for(int count = 1;count <= testCase;count++) {
            nowRow = nowCol = direction = 0;

            int row = sc.nextInt();
            int col = sc.nextInt();
            String strBin = sc.nextLine();
            int[][] chart = new int[row][col];
            boolean[][] copyChart = new boolean[row][col];
            int[] binary = new int[5];
            boolean filled;
            char[] sen = new char[200];

            for(int i = 0;i<row;i++)
                for(int j = 0;j<col;j++) {
                    chart[i][j] = strBin.charAt(i*col + j + 1) - '0';
                    copyChart[i][j] = true;
                }

            System.out.print(count + " ");

            for(int i = 0;true;i++) {
                filled = popBinary(binary, chart, copyChart, row, col);

                if(filled)
                    break;

                sen[i] = binaryToChar(binary);
            }

            int end = 0;
            for(end = 199;end>=0;end--)
                if('A' <= sen[end] && sen[end] <= 'Z')
                    break;

            int start = 0;
            for(start = 0;start < 200;start++)
                if('A' <= sen[start] && sen[start] <= 'Z')
                    break;

            for(int i = start;i<=end;i++)
                System.out.print((char)sen[i]);

            System.out.println();
        }
    }

    public static boolean popBinary(int[] binary, int[][] chart, boolean[][] copyChart, int row, int col) {
        for(int i = 0;i<5;i++) {

            if(nowRow == -1 || nowRow == row || nowCol == -1 || nowCol == col)
                return true;
            if(!copyChart[nowRow][nowCol])
                return true;

            binary[i] = chart[nowRow][nowCol];
            copyChart[nowRow][nowCol] = false;
            switch (direction) {
                case 0 : {
                    if(nowCol+1 == col) {
                        direction = 1;
                        nowRow++;
                        break;
                    }
                    else if(!copyChart[nowRow][nowCol+1]) {
                        direction = 1;
                        nowRow++;
                    }
                    else {
                        nowCol++;
                    }
                    break;
                }
                case 1 : {
                    if(nowRow+1 == row) {
                        direction = 2;
                        nowCol--;
                        break;
                    }
                    else if(!copyChart[nowRow+1][nowCol]) {
                        direction = 2;
                        nowCol--;
                    }
                    else {
                        nowRow++;
                    }
                    break;
                }
                case 2 : {
                    if(nowCol -1 == -1) {
                        direction = 3;
                        nowRow--;
                        break;
                    }
                    else if(!copyChart[nowRow][nowCol-1]) {
                        direction = 3;
                        nowRow--;
                    }
                    else {
                        nowCol--;
                    }
                    break;
                }
                case 3 : {
                    if(nowRow-1 == -1) {
                        direction = 0;
                        nowCol++;
                        break;
                    }
                    else if(!copyChart[nowRow-1][nowCol]) {
                        direction = 0;
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

    public static char binaryToChar(int[] binary) {
        int sum = 0;

        for(int i = 0;i<5;i++) {
            sum = sum*2 + binary[i];
        }

        if(sum == 0)
            return ' ';
        else
            return (char)(sum+'A'-1);
    }
}
