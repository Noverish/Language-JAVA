import java.util.*;

public class Main0406 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String[] sen = new String[3];


        sen[0] = sc.nextLine();
        sen[1] = sc.nextLine();
        sen[2] = sc.nextLine();

        for(int i = 0;i<2;i++) {
            for(int j = i+1;j<3;j++) {
                if(sen[j].compareTo(sen[i]) < 0) {
                    String swap = sen[i];
                    sen[i] = sen[j];
                    sen[j] = swap;
                }
            }
        }

        for(int i = 0;i<3;i++) {
            if(i==2)
                System.out.print(sen[i]);
            else
                System.out.print(sen[i] + " ");
        }
    }
}