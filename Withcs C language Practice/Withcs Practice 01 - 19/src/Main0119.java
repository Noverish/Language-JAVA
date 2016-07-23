import java.util.*;
import java.io.*;

public class Main0119 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));

        while(sc.hasNextLine()) {
            String str = sc.nextLine();

            String ans = new StringBuilder(str).reverse().toString();

            System.out.println(ans);
        }
    }
}