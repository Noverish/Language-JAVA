import java.util.Scanner;

public class Main05N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        String[] input = new String[testCase];
        input[0] = sc.nextLine();

        for(int i = 0;i<testCase ; i++) {
            input[i] = sc.nextLine();
        }

        for(int i = 0;i<testCase - 1;i++)
            for(int j = i + 1;j < testCase;j++)
                if(input[i].length() > input[j].length()) {
                    String tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }

        int i,j;
        String compare = null;

        A:for(int gap = input[0].length() ; gap>0 ; gap--) {
            for(i = 0,j = gap;j<=input[0].length();i++, j++) {
                compare = input[0].substring(i,j);
                int match = 0;

                for(int a = 1;a<testCase;a++) {
                    int tmp = input[a].indexOf(compare);

                    if (tmp != -1)
                        match++;

                }

                if(match==testCase-1)
                    break A;
            }
        }

        System.out.println(compare);

    }
}
