import java.util.*;

public class Main07A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] score = new int[100];
        int highScore = 0;

        for(int i = 0;i < testCase;i++) {
            score[i] = sc.nextInt();
            if(highScore < score[i])
                highScore = score[i];
        }

        for(int i = 0;i < testCase;i++) {
            if(score[i] >= highScore - 10)
                System.out.println("A");
            else if(score[i] >= highScore - 20)
                System.out.println("B");
            else if(score[i] >= highScore - 30)
                System.out.println("C");
            else if(score[i] >= highScore - 40)
                System.out.println("D");
            else
                System.out.println("F");
        }
    }
}
