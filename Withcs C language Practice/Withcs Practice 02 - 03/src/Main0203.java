import java.util.Scanner;

public class Main0203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case;
        char ch;
        int i;
        int testIndex;
        int digit;
        int ans=0;
        int print_null=0;

        test_case = sc.nextInt();
        String tmp = sc.nextLine();

        for(testIndex = 0;testIndex<test_case;testIndex++) {

            char[] number = new char[20];
            print_null=0;
            ans=0;

            tmp = sc.nextLine();

            for(i=0;true;i++) if(number[i]==0) break;

            for(i = 0;i<tmp.length();i++)
                number[i] = tmp.charAt(i);

            digit=i-3;

            if((number[0]=='0'&&number[1]=='x') || (number[0]=='0'&&number[1]=='X')) {
                for(ch=2;ch<i;ch++) {
                    switch (number[ch])
                    {
                        case 'a':
                        case 'A': {
                            number[ch]='9'+1;
                            break;
                        }
                        case 'b':
                        case 'B': {
                            number[ch]='9'+2;
                            break;
                        }
                        case 'c':
                        case 'C': {
                            number[ch]='9'+3;
                            break;
                        }
                        case 'd':
                        case 'D': {
                            number[ch]='9'+4;
                            break;
                        }
                        case 'e':
                        case 'E': {
                            number[ch]='9'+5;
                            break;
                        }
                        case 'f':
                        case 'F': {
                            number[ch]='9'+6;
                            break;
                        }
                        case '0' : case '1' : case '2' : case '3' : case '4' : case '5' : case '6' : case '7' : case '8' : case '9' : break;
                        default : {
                            print_null=1;
                            break;
                        }
                    }
                    if(print_null==1) break;

                    int nothing;
                    nothing =  (int)  Math.pow((double) 16, (double) digit);
                    ans+=(number[ch]-'0') * nothing;
                    digit--;
                }
                if(print_null==0) System.out.printf("%d\n", ans);
                else System.out.printf("null\n");
            }
            else System.out.printf("null\n");
        }

    }
}
