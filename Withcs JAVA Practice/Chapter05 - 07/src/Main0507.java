import java.util.*;

public class Main0507 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i = num -1;i>=0;i--) {
            for(int p = 0;p<i;p++) System.out.print("    ");

            int j;

            for(j = 0;j<num-i-1;j++) System.out.printf("%4d", (int)Math.pow((double) 2, (double) j));

            for(;j>=0;j--) System.out.printf("%4d", (int)Math.pow((double) 2, (double) j));

            System.out.print("\n");
        }
    }
}
