import java.util.*;

public class Main06E {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            number = sc.nextLine();
            lenght = number.length();
            int realnum = Integer.parseInt(number);

            boolean[] table = new boolean[realnum + 1];

            for(int i = 0;i <= realnum;i++) {
                table[i] = true;
            }
            table[0] = table[1] = false;



            for(int i = 2;i <= realnum;i++) {
                if(table[i]) {
                    for (int j = 2; i * j <= realnum; j++) {
                        table[i * j] = false;
                    }
                }
            }

            for(int a = 0;a <= realnum;a++) {
                if(table[a]) {
                    if(0 <= a && a <= 9) {
                        continue;
                    }

                    number = a + "";
                    lenght = number.length();

                    int i;

                    for(i = 1;i<=lenght/2;i++) {
                        if(number.charAt(i - 1) != number.charAt(lenght - i)) {
                            break;
                        }
                    }

                    if(i == lenght/2 + 1) {

                    }
                    else {
                        table[a] = false;
                    }
                }
            }

            int ans = 0;

            for(int i = 0;i <= realnum;i++) {
                if(table[i])
                    ans++;
            }

            System.out.println(ans);
        }
    }
}
