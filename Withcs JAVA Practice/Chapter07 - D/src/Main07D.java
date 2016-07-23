import java.util.*;

public class Main07D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] hori = new int[8];
        int[] verti = new int[8];
        int[] diag = new int[15];

        for(int i = 0;i<8;i++)
            diag[i] = hori[i] = verti[i] = 0;

        for(int i = 0;i<8;i++) {
            String sen = sc.nextLine();

            for(int j = 0;j<8;j++) {
                if(sen.charAt(j) == 'Q') {
                    hori[j]++;
                    verti[i]++;
                    diag[7 + (j-i)]++;

                    if(hori[j] > 1 || verti[i] > 1 || diag[7 + (j-i)] > 1) {
                        System.out.println("Invalid");
                        return;
                    }
                }
            }
        }

        System.out.println("Valid");
    }
}
