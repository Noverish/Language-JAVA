import java.util.Scanner;

public class Main99A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {

            int input = sc.nextInt();

            if(input == 0)
                break;

            char[] number = String.valueOf(input).toCharArray();
            int answer = 0;

            while(true) {
                int sum = 0;
                for (char ch : number)
                    sum += (ch -'0');

                if(sum < 10) {
                    answer = sum;
                    break;
                }
                else
                    number = String.valueOf(sum).toCharArray();
            }

            System.out.println(answer);
        }
    }
}