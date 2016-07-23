import java.util.Scanner;

public class Main12B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String hex = sc.next();
            int value;
            try {
                value = HexFormat.parseHex(hex);
            } catch (HexFormatException ex) {
                System.out.println(ex);
                continue;
            }
            System.out.println(value);
        }
    }
}

class HexFormat{
    public static int parseHex(String input) throws HexFormatException{
        if(!input.matches("[0-9A-F]+")) {
            char[] inputs = input.toCharArray();
            char except = 'a';

            for(char ch : inputs) {
                if('0' <= ch && ch <= '9');
                else if('A' <= ch && ch <= 'F');
                else {
                    except = ch;
                    break;
                }
            }

            HexFormatException hx = new HexFormatException(except);
            throw hx;
        }

        return Integer.parseInt(input, 16);
    }
}

class HexFormatException extends Exception {
    public HexFormatException(char except) {
        super("Illegal hex character: " + except);
    }
}

/*
import java.util.Scanner;

public class Main12B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<testCase;i++) {
            String input = sc.nextLine();

            if(input.matches("[0-9A-F]+")) {
                System.out.println(Integer.parseInt(input,16));
            }
            else {

            }
        }
    }
}
*/