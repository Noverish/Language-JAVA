import java.math.*;
import java.util.*;

public class Main18B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for(int i=0; i<T; i++){
            int num = input.nextInt();
            System.out.println(fibonacci(num));
        }
    }

    public static String fibonacci(int num) {
        double up1 = (1+Math.sqrt(5))/2;
        double up2 = (1-Math.sqrt(5))/2;
        up1 = Math.pow(up1,num);
        up2 = Math.pow(up2,num);
        double answer = (up1-up2)/Math.sqrt(5);

        return String.valueOf((int)answer);
    }
}
