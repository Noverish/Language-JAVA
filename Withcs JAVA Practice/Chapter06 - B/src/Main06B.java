import java.util.*;

public class Main06B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            number = sc.nextLine();

            lenght = number.length();

            for(int i=0;i<lenght;i++) {
                System.out.print(number.charAt(lenght-1-i));
            }

            System.out.print("\n");
        }

    }
}
