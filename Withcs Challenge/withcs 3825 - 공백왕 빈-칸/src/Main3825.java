import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main3825 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        String[][] strs = new String [1000][];
        int maxWord = 0, lineNum = 0;
        int[] wordLengths;

        for(int i = 0;sc.hasNextLine();i++) {
            strs[i] = sc.nextLine().trim().split("[ ]+");
            maxWord = (maxWord >= Array.getLength(strs[i])) ? maxWord : Array.getLength(strs[i]);
            lineNum = i+1;
        }

        wordLengths = new int[maxWord];

        for(int i = 0;i<maxWord;i++) {
            for(int j = 0;j<lineNum;j++) {
                if(Array.getLength(strs[j]) >= (i+1)) {
                    wordLengths[i] = (wordLengths[i] > strs[j][i].length()) ? wordLengths[i] : strs[j][i].length();
                }
            }
        }

        for(int i = 0;i<lineNum;i++) {
            for(int j = 0;j<Array.getLength(strs[i]);j++) {
                int len = strs[i][j].length();

                String tmp;

                if(j != Array.getLength(strs[i])-1)
                    tmp = String.format("%1$"+(wordLengths[j]+1)*-1+ "s", strs[i][j]);
                else
                    tmp = strs[i][j];


                System.out.print(tmp);
            }
            System.out.println();
        }
    }
}
