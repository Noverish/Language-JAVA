import java.util.*;

public class Main06A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            int i;

            number = sc.nextLine();

            lenght = number.length();

            if(lenght == 1) {
                System.out.println("Y");
                continue;
            }

            for(i = 1;i<=lenght/2;i++) {
                if(number.charAt(i - 1) != number.charAt(lenght - i)) {
                    break;
                }
            }

            if(i == lenght/2 + 1) {
                System.out.println("Y");
            }
            else {
                System.out.println("N");
            }
        }

    }
}
