import java.util.*;

public class Main0201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ch=0;

        long number=0;
        int i;
        int digit;
        int end=1;


        while(true) {


            char[] num = new char[50];
            end=0;
            number=0;


            for(int a = 0;a<50;a++)
                num[a] = 0;

            String tmp = sc.nextLine();

            for(int a = 0;a<tmp.length();a++)
                num[a] = tmp.charAt(a);

            if(num[0]==0) break;

            for(i=0;true;i++) {
                if(num[i]==0) break;
            }


            digit=i-1;

            for(i=0;true;i++) {
                if('0'<=num[i] && num[i]<='9')
                    num[i]-='0';
                if(i==digit) break;
            }


            if(num[0]=='-') {
                digit--;

                if(digit>10) {
                    System.out.printf("signed int64\n");
                    continue;
                }

                for(i=1;digit>=0;i++) {
                    number+=num[i]*Math.pow((double) 10, (double) digit);
                    digit--;
                }
                number*=-1;
            }
            else {

                if(digit>10) {
                    System.out.printf("unsigned int64\n");
                    continue;
                }

                for(i=0;digit>=0;i++) {
                    number+=num[i]*Math.pow((double) 10, (double) digit);
                    digit--;
                }
            }



            if(-Math.pow((double) 2, (double) 63) <= number && number <= -1 -Math.pow((double) 2, (double) 31)  )
                System.out.printf("signed int64\n");
            if(-Math.pow((double) 2, (double) 31) <= number && number <= -1 -Math.pow((double) 2, (double) 15)  )
                System.out.printf("signed long\n");
            if(-Math.pow((double) 2, (double) 15) <= number && number <= -1 -Math.pow((double) 2, (double) 7)  )
                System.out.printf("signed short\n");
            if(-Math.pow((double) 2, (double) 7) <= number && number <= -1)
                System.out.printf("signed byte\n");
            if(              0                <= number && number <= Math.pow((double) 2, (double) 8)-1)
                System.out.printf("unsigned byte\n");
            if( Math.pow((double) 2, (double) 8) <= number && number <= Math.pow((double) 2, (double) 16)-1)
                System.out.printf("unsigned short\n");
            if( Math.pow((double) 2, (double) 16) <= number && number <= Math.pow((double) 2, (double) 32)-1)
                System.out.printf("unsigned long\n");
            if( Math.pow((double) 2, (double) 32) <= number && number <= Math.pow((double) 2, (double) 64)-1)
                System.out.printf("unsigned int64\n");

            if(end==-1) break;
        }
    }
}
