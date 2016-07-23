import java.math.*;
import java.util.*;

public class Main18A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for(int i=0; i<T; i++){
            String numberString = input.nextLine();
            BigInteger bigNumber = new BigInteger(numberString);
            System.out.println(factorial(bigNumber));
        }
    }

    public static String factorial(BigInteger num) {
        if(num.equals(BigInteger.ZERO))
            return BigInteger.ONE.toString();
        else {
            BigInteger answer = new BigInteger("1");
            int limit = Integer.parseInt(num.toString());
            for(int i = 1;i<=limit;i++) {
                answer = answer.multiply(new BigInteger(String.valueOf(i)));
            }
            return answer.toString();
        }
    }
}
