import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double number;
        int feet, inch;

        number = sc.nextDouble();

        inch = (int)(number*39.3701);
        feet = inch - (inch%12);
        feet/=12;
        inch%=12;

        System.out.println(feet);
        System.out.println(inch);

    }
}