import java.util.*;

public class Main09D{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(;testCase>0;testCase--) {

            Calendar cl = new GregorianCalendar(sc.nextInt(),sc.nextInt()-1,sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());

            cl.add(cl.DAY_OF_MONTH, 1000);
            cl.add(cl.SECOND, -1000);

            System.out.printf("%04d.%02d.%02d ", cl.get(cl.YEAR), cl.get(cl.MONTH) + 1, cl.get(cl.DAY_OF_MONTH));
            System.out.printf("%02d:%02d:%02d\n", cl.get(cl.HOUR_OF_DAY), cl.get(cl.MINUTE),cl.get(cl.SECOND));
        }
    }
}
