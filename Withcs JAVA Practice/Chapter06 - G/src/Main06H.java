import java.util.*;

public class Main06H {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            number = sc.nextLine();
            lenght = number.length();

            int even = 0, odd = 0;

            for(int i = lenght - 2;i>=0;i-=2) {
                char ch = number.charAt(i);
                int a = ch - '0';
                a *= 2;
                even += a%10 + a/10;
            }

            for(int i = lenght - 1;i>=0;i-=2) {
                char ch = number.charAt(i);
                int a = ch - '0';
                odd += a;
            }


            if((odd + even)%10 == 0) {
                if('3' <= number.charAt(0) && number.charAt(0) <='6') {
                    if(number.charAt(0) == '3') {
                        if(number.charAt(1) == '7') {
                            System.out.println("Valid");
                        }
                        else {
                            System.out.println("Invalid");
                        }
                    }
                    else{
                        System.out.println("Valid");
                    }

                }
                else {
                    System.out.println("Invalid");
                }




            }
            else
                System.out.println("Invalid");

        }
    }
}
