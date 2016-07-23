import java.util.*;

public class Main06D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int lenght;
        int testCase = sc.nextInt();
        String number = sc.nextLine();

        for(;testCase>0;testCase--) {
            number = sc.nextLine();
            lenght = number.length();

            for(int i=0;i<lenght;i++) {
                char ch = number.charAt(i);

                if('a' <= ch && ch <= 'z') {
                    System.out.print(atonum(ch));
                }
                else if('A' <= ch && ch <= 'Z') {
                    ch -= 'A';
                    ch += 'a';
                    System.out.print(atonum(ch));
                }
                else {
                    System.out.print(ch);
                }
            }
            System.out.print("\n");
        }

    }

    static int atonum(char alpa) {

        switch (alpa) {
            case 'a':
            case 'b':
            case 'c':
                return 2;
            case 'd':
            case 'e':
            case 'f':
                return 3;
            case 'g':
            case 'h':
            case 'i':
                return 4;
            case 'j':
            case 'k':
            case 'l':
                return 5;
            case 'm':
            case 'n':
            case 'o':
                return 6;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return 7;
            case 't':
            case 'u':
            case 'v':
                return 8;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return 9;
            default:
                return -1;
        }
    }
}
