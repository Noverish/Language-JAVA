import java.util.Scanner;

public class Main3439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int lottoNum = sc.nextInt();
            int[] totoro = new int[50];

            if(lottoNum == 0)
                break;

            for(int i = 0;i<50;i++)
                totoro[i] = 0;

            for(int i = 0;i<lottoNum*6;i++)
                totoro[sc.nextInt()]++;

            int check = 0;

            for(check = 1;check<50;check++)
                if(totoro[check] == 0)
                    break;

            if(check == 50)
                System.out.println("Yes");
            else
                System.out.println("No");


        }
    }
}
