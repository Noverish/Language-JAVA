import java.util.*;

public class Main10C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            double x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            x3 = sc.nextDouble();
            y3 = sc.nextDouble();
            x4 = sc.nextDouble();
            y4 = sc.nextDouble();
            x5 = sc.nextDouble();
            y5 = sc.nextDouble();

            MyRectangle2D r1 = new MyRectangle2D(x1, y1, x2, y2);
            MyRectangle2D r2 = new MyRectangle2D(x3, y3, x4, y4);

            System.out.printf("Area is %.1f\n", r1.getArea());
            System.out.printf("Perimeter is %.1f\n", r1.getPerimeter());
            System.out.println(r1.contains(x5, y5));
            if (r1.contains(r2)) {
                System.out.println("contain");
            } else if (r1.overlaps(r2)) {
                System.out.println("overlaps");
            } else {
                System.out.println("no overlap");
            }
        }
    }
}

class MyRectangle2D {
    private double x, y;
    private double width, height;
    private double[][] points = new double[4][2];
    private double x1, x2, y1, y2;

    public MyRectangle2D(double a1, double b1, double a2, double b2) {
        x = a1;
        y = b1;
        width = a2;
        height = b2;

        x1 = a1-(a2/2);
        x2 = a1+(a2/2);
        y1 = b1-(b2/2);
        y2 = b1+(b2/2);

        points[0][0] = x1;
        points[0][1] = y1;
        points[1][0] = x1;
        points[1][1] = y2;
        points[2][0] = x2;
        points[2][1] = y1;
        points[3][0] = x2;
        points[3][1] = y2;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return 2*(height + width);
    }

    public boolean contains(double x0, double y0) {
        if(Math.abs(x0 - x) <= width/2 && Math.abs(y0 - y) <= height/2)
            return true;
        else
            return false;
    }

    public boolean contains(MyRectangle2D r) {
        int ok = 0;

        for(int i = 0;i<4;i++) {
            if(this.contains(r.points[i][0], r.points[i][1])) {
                ok++;
            }
        }

        if(ok == 4)
            return true;
        else
            return false;
    }

    public boolean overlaps(MyRectangle2D r) {

        if(r.x1 < this.x1 && this.x2 < r.x2 && r.y1 < this.y1 && this.y2 < r.y2)
            return true;

        if(r.x2 < this.x1 || this.x2 < r.x1 || r.y2 < this.y1 || this.y2 < r.y1 ) {
            return false;
        }
        else
            return true;
    }
}
