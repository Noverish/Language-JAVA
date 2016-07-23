import java.util.*;

public class Main07B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] score = new int[205];

        for(int i = 0;i < 205;i++) {
            score[i] = 0;
        }

        for(int i = 0;i < testCase;i++) {
            int num = sc.nextInt();

            score[num+100]++;
        }

        for(int i = 0;i < 205;i++) {
            if(score[i] > 0)
                System.out.println(i-100 + " " + score[i]);
        }
    }
}
