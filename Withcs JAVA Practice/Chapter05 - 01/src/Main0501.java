import java.util.*;

public class Main0501 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String[] name = new String[10];
        int[] score = new int[10];
        int studentNumber;

        studentNumber = sc.nextInt();
        String trash = sc.nextLine();

        for(int i = 0;i < studentNumber;i++) {
            String str = sc.nextLine();

            String tok[] = str.split(" ",2);

            name[i] = tok[0];
            score[i] = Integer.parseInt(tok[1]);
        }

        for(int i = 0;i < studentNumber -1;i++) {
            for(int j = i;j < studentNumber;j++) {
                if(score[i] < score[j]) {
                    String tmp = name[i];
                    name[i] = name[j];
                    name[j] = tmp;

                    int tmpInt = score[i];
                    score[i] = score[j];
                    score[j] = tmpInt;
                }
            }
        }

        System.out.println(name[0] + " " + score[0]);
        System.out.println(name[1] + " " + score[1]);
    }
}
