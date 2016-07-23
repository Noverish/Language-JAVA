import java.util.Scanner;

public class Main99B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int z = 0;z<testCase;z++) {
            int loc = sc.nextInt();
            String str = sc.nextLine();

            String str1 = str.substring(0,loc);
            String str2 = str.substring(loc+1,str.length());

            String answer = str1 + str2;
            System.out.println((z+1) + answer);
        }
    }
}
