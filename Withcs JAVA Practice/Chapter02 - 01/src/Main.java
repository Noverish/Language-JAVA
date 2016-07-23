import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int time, sec, min, hour;

        time = sc.nextInt();

        sec = time%60;
        time/=60;
        min = time%60;
        time/=60;
        hour = time;

        System.out.print(hour + " " + min + " " + sec);
    }
}