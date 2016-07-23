import java.util.*;

public class Main0405 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String sen;
        char word1, word2;

        sen = sc.nextLine();
        word1 = sen.charAt(0);
        word2 = sen.charAt(1);

        if(word1 == 'M' || word1 == 'm')
            System.out.print("Mathematics ");
        else if(word1 == 'C' || word1 == 'c')
            System.out.print("Computer Science ");
        else if(word1 == 'I' || word1 == 'i')
            System.out.print("Information Technology ");

        if(word2 == '1')
            System.out.print("Freshman");
        else if(word2 == '2')
            System.out.print("Sophomore");
        else if(word2 == '3')
            System.out.print("Junior");
        else if(word2 == '4')
            System.out.print("Senior");
    }
}