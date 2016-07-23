import java.util.Scanner;

public class Main4274 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0, max, sum;
        int t;

        num = sc.nextInt();

        max = sum = 0;
        for(int i = 0;i<num;i++){
            t = sc.nextInt();
            sum += t;
            if (sum < 0) sum = 0;
            else if (sum > max) max = sum;


        }
        System.out.printf("%d", max);

    }
}