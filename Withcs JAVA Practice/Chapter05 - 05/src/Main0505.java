import java.util.*;

public class Main0505 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int i;

        for( i = num -1;i>0;i--) {
            for(int j = 0;j<i;j++) System.out.print(" ");

            for(int j = 0;j<num-i-1;j++) System.out.print("*");

            System.out.print("*");

            for(int j = 0;j<num-i-1;j++) System.out.print("*");

            System.out.print("\n");
        }

        for(;i <= num-1;i++) {
            for(int j = 0;j<i;j++) System.out.print(" ");

            for(int j = 0;j<num-i-1;j++) System.out.print("*");

            System.out.print("*");

            for(int j = 0;j<num-i-1;j++) System.out.print("*");

            System.out.print("\n");
        }
    }
}
