import java.util.Scanner;

public class Main1013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String input = sc.nextLine();
            int[] num1 = charArrayToIntArray(input.split(" ")[0].toCharArray());
            int[] num2 = charArrayToIntArray(input.split(" ")[1].toCharArray());
            int answer = 0;

            if(num1.length == 1 && num2.length == 1)
                if(num1[0] == 0 && num2[0] == 0)
                    break;

            if(num2.length > num1.length) {
                int[] tmp = num1.clone();
                num1 = num2.clone();
                num2 = tmp.clone();
            }


            for (int i = 0; i < num2.length; i++) {
                int num1NowLoc = num1.length - i - 1;
                int num2NowLoc = num2.length - i - 1;
                num1[num1NowLoc] += num2[num2NowLoc];
            }

            while(true) {
                int originAnswer = answer;

                for(int i = 1;i<num1.length;i++)
                    if(num1[i] >= 10) {
                        num1[i-1] += 1;
                        num1[i] -= 10;
                        answer++;
                    }

                if(answer == originAnswer)
                    break;
            }

            if(num1[0] >= 10)
                answer++;

            if(answer == 0)
                System.out.println("No carry operation.");
            else if(answer == 1)
                System.out.println(answer + " carry operation.");
            else
                System.out.println(answer + " carry operations.");
        }
    }

    private static int[] charArrayToIntArray(char[] chars) {
        int[] input = new int[chars.length];

        for(int i = 0;i<chars.length;i++) {
            input[i] = chars[i]-'0';
        }

        return input;
    }
}
