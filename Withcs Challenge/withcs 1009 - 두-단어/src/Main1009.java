import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main1009 {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        String[] word = new String[120000];

        int i = 0;
        while(sc.hasNextLine()){
            word[i++] = sc.nextLine();
        }

        final int wordNum = i;

        for(i = 0;i<wordNum-1;i++) {
            if(word[i+1].indexOf(word[i]) != -1) {
                String tmp = word[i+1].substring(word[i].length(), word[i + 1].length());
                if(Arrays.asList(word).contains(tmp)) {
                    System.out.println(word[i+1]);
                }
            }
        }
    }
}
