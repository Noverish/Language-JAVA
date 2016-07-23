import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        double radius, lenght;
        double area, volumn;
        long num;

        radius = sc.nextDouble();
        lenght = sc.nextDouble();

        area = radius * radius * 3.14159;
        volumn = area * lenght;

        num = (long)Math.floor(area*10);
        area = (double)num/10;

        num = (long)Math.floor(volumn*10);
        volumn = (double)num/10;

        System.out.printf("%.1f\n",area);
        System.out.printf("%.1f",volumn);
    }
}