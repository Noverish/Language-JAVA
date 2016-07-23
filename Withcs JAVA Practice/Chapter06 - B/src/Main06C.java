import java.util.*;

public class Main06C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            number = sc.nextLine();

            lenght = number.length();

            if(lenght<8)
                System.out.println("Invalid");
            else {
                int i;

                for(i = 0;i<lenght;i++) {
                    char ch = number.charAt(i);

                    if('0' <= ch && ch <= '9');
                    else if('a' <= ch && ch <= 'z');
                    else if('A' <= ch && ch <= 'Z');
                    else {
                        System.out.println("Invalid");
                        break;
                    }
                }

                if(i==lenght) {
                    int numnum = 0;

                    for(i = 0;i<lenght;i++) {
                        char ch = number.charAt(i);

                        if('0' <= ch && ch <= '9')
                            numnum++;
                    }

                    if(numnum < 2)
                        System.out.println("Invalid");
                    else
                        System.out.println("Valid");
                }
            }
        }

    }
}
