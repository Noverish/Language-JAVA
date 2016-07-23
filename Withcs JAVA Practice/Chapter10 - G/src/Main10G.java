import java.math.BigInteger;
import java.util.*;

public class Main10G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger big = new BigInteger(sc.nextLine());
        BigInteger num = new BigInteger("100019");

        big = big.add(num);
        big = big.add(big.mod(num).multiply(new BigInteger("-1")));

        System.out.println(big.toString());
    }
}
