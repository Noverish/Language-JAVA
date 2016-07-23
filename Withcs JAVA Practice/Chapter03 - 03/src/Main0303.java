import java.util.*;

public class Main0303 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        int date;

        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();

        if(month == 1 || month == 2) {
            month+=12;
            year--;
        }

        date = dateProcess(year, month, day);

        switch(date) {
            case 0 : {
                System.out.println("Saturday");
                break;
            }
            case 1 : {
                System.out.println("Sunday");
                break;
            }
            case 2 : {
                System.out.println("Monday");
                break;
            }
            case 3 : {
                System.out.println("Tuesday");
                break;
            }
            case 4 : {
                System.out.println("Wednesday");
                break;
            }
            case 5 : {
                System.out.println("Thursday");
                break;
            }
            case 6 : {
                System.out.println("Friday");
                break;
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
}
