import java.util.Scanner;

public class Main3247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a,b;
        while(true) {

            a = sc.nextInt();
            b = sc.nextInt();
            if((b==-1)&&(a==-1))
                break;

            if((a+b)==pactorial(a+b,b))
                System.out.printf("%d+%d=%d\n", a, b, a + b);
            else
                System.out.printf("%d+%d!=%d\n", a, b, a + b);

        }

    }

    public static long pactorial(int n, int r) {
        if(r==n) return 1;
        double sum=1;
        int x=n-r;
        for(;n>1;n--) {
            sum*=n;
            sum/=r;
            sum/=x;
            if(r!=1) r--;
            if(x!=1) x--;
        }
        sum+=0.1;
        return (long)sum;
    }
}
