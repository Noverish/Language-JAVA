import java.util.Scanner;

public class Main4275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number, section_num;
        int[] num = new int[100000];
        int[] sum_num = new int[100000];
        int sec_start, sec_end;
        int ans=0;
        int sum=0;
        int i,j;


        number = sc.nextInt();
        section_num = sc.nextInt();

        for(i=0;i<number;i++)
            num[i] = sc.nextInt();

        sum_num[0]=num[0];

        for(i=1;i<number;i++) {
            sum_num[i]=sum_num[i-1]+num[i];
        }


        for(i=0;i<section_num;i++)
        {
            sec_start = sc.nextInt();
            sec_end = sc.nextInt();

            if(sec_start==0) sum=sum_num[sec_end];
            else sum=sum_num[sec_end]-sum_num[sec_start-1];

            ans=max(ans, sum);

            sum=0;
        }

        System.out.printf("%d",ans);

    }

    public static int max(int a, int b)
    {
        if(a>b) return a;
        else return b;
    }
}