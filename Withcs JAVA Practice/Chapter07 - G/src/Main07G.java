import java.util.*;

public class Main07G {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(;testCase > 0;testCase--) {
            int stuNum = sc.nextInt();
            int locker = sc.nextInt();
            int i;
            for(i = 1;i < 1000;i++) {
                if(i*i == locker)
                    break;
            }

            if(i == 1000) {
                System.out.println("close");
            }
            else {
                System.out.println("open");
            }
        }
    }
}
