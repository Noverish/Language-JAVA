import java.util.*;

public class Main0510 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int month = sc.nextInt();

        int date = day(year, month);
        int dayofMonth = 0;

        date = (date+6)%7;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
                dayofMonth = 31;
                break;
            }
            case 4: case 6: case 9: case 11: {
                dayofMonth = 30;
                break;
            }
            case 2:{
                dayofMonth = 28;
                break;
            }
        }

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int i;
        int asdf;

        for(i = 0;i<date;i++) {
            System.out.print("    ");
        }

        for(asdf = 1;asdf<=dayofMonth;asdf++,i++) {
            System.out.printf("%2d", asdf);
            if(i%7==6)
                System.out.print("\n");
            else {
                if (asdf != dayofMonth)
                    System.out.print("  ");
            }
        }

    }

    public static int dateProcess(int year, int month, int day) {
        int h, q, m, k, j;

        q = day;
        m = month;
        j = year/100;
        k = year%100;

        h = (q + (26*(m+1)/10) + k + k/4 + j/4 + 5*j) % 7;

        return h;
    }

    public static int day(int year, int month) {
        int day = 1;
        int date;

        if(month == 1 || month == 2) {
            month+=12;
            year--;
        }

        date = dateProcess(year, month, day);

        return date;
    }
}
