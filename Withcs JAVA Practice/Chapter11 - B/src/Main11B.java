import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main11B {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));
        ArrayList<Double> pointX = new ArrayList<Double>();
        ArrayList<Double> pointY = new ArrayList<Double>();

        int lineNum = sc.nextInt();
        double area = 0;

        for(int i = 0;i<lineNum;i++) {
            pointX.add(sc.nextDouble());
            pointY.add(sc.nextDouble());
        }

        for(int i = 0;i<lineNum;i++) {
            area += pointX.get(i%lineNum) * pointY.get((i+1)%lineNum);
            area -= pointX.get((i+1)%lineNum) * pointY.get(i%lineNum);
        }

        area = Math.abs(area/2);

        System.out.printf("The total area is %.2f",area);
    }
}
