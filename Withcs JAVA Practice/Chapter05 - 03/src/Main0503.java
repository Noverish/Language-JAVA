import java.util.*;

public class Main0503 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase;
        int number;

        testCase = sc.nextInt();

        for(int j = 0; j<testCase;j++) {

            number = sc.nextInt();

            for(int i = 2;i <= number;) {
                if((number % i) == 0) {
                    System.out.print(i);
                    number/=i;
                    if(number != 1)
                        System.out.print(" ");
                    else
                        break;
                }
                else
                    i++;
            }
            
            System.out.print("\n");
        }

    }
}
