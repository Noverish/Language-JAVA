import java.util.*;

public class Main4313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nowYear, nowMonth, nowDay;
        String nowDate = null;

        String input = sc.nextLine();
        String[] split = input.split("/");

        if(split.length == 3) {
            nowYear = Integer.getInteger(split[0]);
            nowMonth = Integer.getInteger(split[1]);
            nowDay = Integer.getInteger(split[2]);
        }
    }
}
