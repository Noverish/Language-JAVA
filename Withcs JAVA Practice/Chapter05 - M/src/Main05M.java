import java.util.*;

public class Main05M {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        String trash = sc.nextLine();

        for(;testCase>0;testCase--) {
            String sen = sc.nextLine();
            int lenght = sen.length();
            int ja = 0, mo = 0;

            for(int i = 0;i < lenght;i++) {
                if (('a' <= sen.charAt(i) && sen.charAt(i) <= 'z') || ('A' <= sen.charAt(i) && sen.charAt(i) <= 'Z')) {
                    switch (sen.charAt(i)) {
                        case 'a' :
                        case 'e' :
                        case 'i' :
                        case 'o' :
                        case 'u' :
                        case 'A' :
                        case 'E' :
                        case 'I' :
                        case 'O' :
                        case 'U' :
                        {
                            mo++;
                            break;
                        }
                        default: {
                            ja++;
                        }
                    }
                }
            }

            System.out.println(mo + " " + ja);
        }
    }
}
