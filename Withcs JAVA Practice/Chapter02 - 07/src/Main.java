import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int money, number;
        double accountMoney = 0;

        money = sc.nextInt();

        for(int i=0;i<6;i++) {
            accountMoney = (money + accountMoney) * 1.00417;
        }

        accountMoney*=10;
        number = (int)Math.floor(accountMoney);
        accountMoney = (double)number/10;

        System.out.println(accountMoney);

    }
}
