import java.util.*;

public class Main09C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(;testCase>0;testCase--) {
            Date dt = new Date(sc.nextLong());

            System.out.println(dt.toString());
        }
    }
}
