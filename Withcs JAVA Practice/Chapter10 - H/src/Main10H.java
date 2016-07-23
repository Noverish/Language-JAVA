import java.util.*;
import java.util.stream.Collector;

public class Main10H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            char ch = sc.next().charAt(0);
            MyCharacter c = new MyCharacter(ch);
            System.out.println(c.charValue());
            System.out.println(c.compareTo(new MyCharacter('i')));
            System.out.println(c.equals(new MyCharacter('i')));
            System.out.println(c.isDigit());
            System.out.println(c.isDigit(ch));
            System.out.println(MyCharacter.isDigit(ch));
            System.out.println(MyCharacter.isLetter(ch));
            System.out.println(MyCharacter.isLetterOrDigit(ch));
            System.out.println(MyCharacter.isLowerCase(ch));
            System.out.println(MyCharacter.isUpperCase(ch));
            System.out.println(MyCharacter.toUpperCase(ch));
            System.out.println(MyCharacter.toLowerCase(ch));
        }

    }
}

class MyCharacter {
    char ch;

    public MyCharacter(char ch) {
        this.ch = ch;
    }

    public char charValue() {
        return ch;
    }

    public int compareTo(MyCharacter a) {
        return (int)(ch-a.charValue());
    }

    public boolean equals(MyCharacter a) {
        return a.charValue() == ch;
    }

    public boolean isDigit() {
        return Character.isDigit(ch);
    }

    public static boolean isDigit(char a) {
        return Character.isDigit(a);
    }

    public static boolean isLetter(char a) {
        return Character.isLetter(a);
    }

    public static boolean isLetterOrDigit(char a) {
        return Character.isLetterOrDigit(a);
    }

    public static boolean isLowerCase(char a) {
        return Character.isLowerCase(a);
    }

    public static boolean isUpperCase(char a) {
        return Character.isUpperCase(a);
    }

    public static char toUpperCase(char a) {
        return Character.toUpperCase(a);
    }

    public static char toLowerCase(char a) {
        return Character.toLowerCase(a);
    }
}
