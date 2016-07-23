import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main0402 {
    public static int resolve_string(char resolving_string[]) {

        int division, power_number = 0, status;
        char[] number_part = new char[15];
        int i,j=0, end=0;

        String str = "";
        
        for(char ch : resolving_string)
            str += String.valueOf(ch);
        
        division = str.indexOf("E");
        if(division == -1)
            division = str.indexOf("e");

        if(resolving_string[division+1] == '+')
            status = 1;
        else
            status = -1;

        for(i=2;i<5;i++)
            power_number = power_number * 10 + (resolving_string[division+i]-'0');
        power_number *= status;


        if(resolving_string[0] == '-')
            j=1;
        for(i=0;i+j<division;i++) {
            number_part[end++] = resolving_string[i+j];
            if(i==0)
                i++;
        }
        number_part[end] = 0;


        for(end--;end>=0;end--) {
            if(number_part[end] == '0')
                number_part[end] = 0;
            else break;
        }

        if(resolving_string[0] == '-')
            System.out.printf("-");
        if(power_number<0) {
            System.out.printf("0.");
            power_number++;
            if(power_number<0) {
                for(;power_number<0;power_number++) {
                    System.out.printf("0");
                }
            }
            for(char ch : number_part) {
                if(ch == 0)
                    break;
                System.out.print(ch);
            }
        }
        else {
            for(i=0;power_number>=0;power_number--) {
                System.out.printf("%c",number_part[i++]);
            }
            System.out.printf(".");
            String str2 = "";
            for(int a=i;a<number_part.length;a++) {
                if(number_part[a] == 0)
                    break;
                str2 += String.valueOf(number_part[a]);
            }
            System.out.printf("%s",(str2));
        }

        System.out.printf("\n");

        return 0;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        int test_case;
        char[] num;

        test_case = sc.nextInt();
        sc.nextLine();

        for(;test_case>0;test_case--) {

            String str2 = sc.nextLine();
            num = str2.toCharArray();

            resolve_string(num);

        }
    }
}
