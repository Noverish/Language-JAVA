import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number, sum = 0;

        number = sc.nextInt();

        for(int i=0;number>0;i++) {
            sum += number % 10;
            number/=10;
        }

        System.out.print(sum);
    }
}