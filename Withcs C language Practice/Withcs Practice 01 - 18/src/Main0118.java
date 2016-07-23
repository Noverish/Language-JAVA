import java.util.*;
import java.io.*;

public class Main0118 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));

        while(sc.hasNextLine()) {
            String str = sc.nextLine();

            int i = 0;
            for(i = str.length()-1;i>=0;i--) {
                if(str.charAt(i) == ' ');
                else if(str.charAt(i) == '\t');
                else if(str.charAt(i) == '\r');
                else {
                    break;
                }
            }

            String ans = str.substring(0,i+1);
            System.out.println(ans);
        }
    }
}