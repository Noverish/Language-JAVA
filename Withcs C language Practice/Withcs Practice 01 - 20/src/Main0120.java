import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main0120 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        while(sc.hasNextLine()) {
            char[] chars = sc.nextLine().toCharArray();
            ArrayList<Character> str = new ArrayList<Character>();

            for(char ch : chars)
                str.add(ch);

            for(int i = 0;i<str.size();i++) {
                if(str.get(i) == '\t') {
                    int index = 4-(i%4);

                    str.remove(i);
                    for(int j = 0;j<index;j++)
                        str.add(i,' ');
                }
            }

            for(char ch : chars)
                System.out.print(ch);
            System.out.println();
        }
    }
}