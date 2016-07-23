import java.util.*;

public class Main05L {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(;testCase>0;testCase--) {
            int num = sc.nextInt();
            int lenght;

            String bin = Integer.toBinaryString((short)num);

            lenght = bin.length();

            if(lenght == 32) {
                String ans = bin.substring(16);
                System.out.println(ans);
            }
            else {
                for(int i=0;i+lenght<16;i++)
                    System.out.print("0");
                System.out.println(bin);
            }
        }
    }
}
