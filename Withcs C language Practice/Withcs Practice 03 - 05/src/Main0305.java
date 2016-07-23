import java.util.Scanner;

public class Main0305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case, digit, number;
        int i,j;

        test_case = sc.nextInt();
        digit = sc.nextInt();

        for(;test_case>0;test_case--) {
            char[] answer = new char[20];
            number = sc.nextInt();
            for(i=0;true;i++) {
                answer[i] = (char)(number%digit);
                if(0<=answer[i] && answer[i]<=9) {
                    answer[i]+='0';
                }
                else {
                    answer[i]-=10;
                    answer[i]+='A';
                }
                number/=digit;
                if(number==0) break;
            }
            for(;i>=0;i--) System.out.printf("%c",answer[i]);
            System.out.printf("\n");
        }
    }
}
