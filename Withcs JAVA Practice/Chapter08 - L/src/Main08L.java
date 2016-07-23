import java.util.Arrays;
import java.util.Scanner;

public class Main08L {
    public static double x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];
        int[] d = new int[2];
        int testCase = sc.nextInt();

        double[] area = new double[4];

        for (; testCase > 0; testCase--) {
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            b[0] = sc.nextInt();
            b[1] = sc.nextInt();
            c[0] = sc.nextInt();
            c[1] = sc.nextInt();
            d[0] = sc.nextInt();
            d[1] = sc.nextInt();

            sort4PointsClockwise(a, b, c, d);

            findIntersection(a[0], a[1], c[0], c[1], b[0], b[1], d[0], d[1]);


            area[0] = triArea(x,y,a[0],a[1],b[0],b[1]);
            area[1] = triArea(x,y,b[0],b[1],c[0],c[1]);
            area[2] = triArea(x,y,c[0],c[1],d[0],d[1]);
            area[3] = triArea(x,y,d[0],d[1],a[0],a[1]);

            Arrays.sort(area);

            for(int i = 0;i<4;i++) {
                int tmp = (int)Math.round(area[i]*100);
                area[i] = (double)tmp/100;
            }

            for(int i = 0;i<3;i++)
                System.out.print(area[i] + " ");

            System.out.println(area[3]);
        }
    }


    static double CrossProductZ(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    static double Orientation(int[] a, int[] b, int[] c) {
        return CrossProductZ(a, b) + CrossProductZ(b, c) + CrossProductZ(c, a);
    }

    static void sort4PointsClockwise(int[] a, int[] b, int[] c, int[] d) {

        if (Orientation(a, b, c) < 0.0) {
            if (Orientation(a, c, d) < 0.0) {
                return;
            } else if (Orientation(a, b, d) < 0.0) {
                swap(d, c);
            } else {
                swap(a, d);
            }
        } else if (Orientation(a, c, d) < 0.0) {
            if (Orientation(a, b, d) < 0.0) {
                swap(b, c);
            } else {
                swap(a, b);
            }
        } else {
            swap(a, c);
        }
    }

    public static void swap(int[] x, int[] y) {
        int tmp = x[0];
        x[0] = y[0];
        y[0] = tmp;

        tmp = x[1];
        x[1] = y[1];
        y[1] = tmp;
    }

    public static void findIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double a = y1 - y2;
        double b = -(x1 - x2);
        double c = y3 - y4;
        double d = -(x3 - x4);
        double e = a * x1 + b * y1;
        double f = c * x3 + d * y3;

        x = (e * d - b * f) / (a * d - b * c);
        y = (a * f - e * c) / (a * d - b * c);

    }

    public static double triArea(double x1, double y1, int x2, int y2, int x3, int y3) {
        double ans = 0;
        ans = (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1);

        return Math.abs(0.5*ans);
    }

}

/*
2
0 0 1 1 2 0 2 -1
0 0 1 1 0 1 1 0
 */