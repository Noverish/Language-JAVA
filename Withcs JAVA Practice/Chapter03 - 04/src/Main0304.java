import java.util.*;

public class Main0304 {
    public static void main(String args[]) {
        Scanner sc =  new Scanner(System.in);

        int[] num = new int[9];
        int lastNum = 0;

        String ans;
        String sen = sc.nextLine();

        for(int i=0;i<9;i++) {
            num[i] = sen.codePointAt(i);
            num[i]-='0';
            lastNum += num[i] * (i+1);
        }

        lastNum%=11;

        if(lastNum != 10)
            ans = sen.concat(String.valueOf(lastNum));
        else
            ans = sen.concat("X");

        System.out.print(ans);
    }
}
