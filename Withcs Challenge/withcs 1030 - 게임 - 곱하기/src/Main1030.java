import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main1030 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextDouble())
        {
            double n;
            double a, b;
            n = sc.nextDouble();

            while (true)
            {
                a = n;
                b = n / 9;

                if (b <= 2)
                {
                    if (a > 9) System.out.println("Ollie wins.");
                    else System.out.println("Stan wins.");

                    break;
                }
                n /= 18;
            }
        }
    }
}
