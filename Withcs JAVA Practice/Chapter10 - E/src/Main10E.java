import javafx.geometry.*;
import java.awt.geom.Line2D;
import java.util.Scanner;

public class Main10E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            double x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7;
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
            x6 = sc.nextDouble();
            y6 = sc.nextDouble();
            x7 = sc.nextDouble();
            y7 = sc.nextDouble();

            Triangle2D r1 = new Triangle2D(x1, y1, x2, y2, x3, y3);
            Triangle2D r2 = new Triangle2D(x4, y4, x5, y5, x6, y6);

            System.out.printf("Area is %.1f\n", r1.getArea());
            System.out.printf("Perimeter is %.1f\n", r1.getPerimeter());
            System.out.println(r1.contains(x7, y7));
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

class Triangle2D {

    private double area;
    private double perimeter;
    public double x1, y1, x2, y2, x3, y3;
    public Point2D[] points = new Point2D[3];
    public Line2D.Double[] lines = new Line2D.Double[3];

    public Triangle2D() {
        this(0,0,1,1,2,5);
    }

    public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;

        points[0] = new Point2D(x1,y1);
        points[1] = new Point2D(x2,y2);
        points[2] = new Point2D(x3,y3);

        for(int i = 0;i<3;i++) {
            perimeter += points[i%3].distance(points[(i+1)%3]);
        }

        area = processArea(points[0],points[1],points[2]);

        for(int i = 0;i<3;i++) {
            lines[i] = new Line2D.Double(points[i%3].getX(),points[i%3].getY(),points[(i+1)%3].getX(),points[(i+1)%3].getY());
        }
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public boolean contains(double x7, double y7) {
        double sum = 0;

        for(int i = 0;i<3;i++) {
            sum += processArea(new Point2D(x7,y7), points[i%3], points[(i+1)%3]);
        }

        return (sum == area);
    }

    public boolean contains(Triangle2D t) {
        for(int i = 0;i<3;i++) {
            if(!this.contains(t.points[i].getX(), t.points[i].getY())) {
                return false;
            }
        }
        return true;
    }

    public boolean overlaps(Triangle2D t) {

        if(t.contains(this))
            return true;

        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                if(t.lines[i].intersectsLine(this.lines[j])) {
                    return true;
                }
            }
        }


        return false;
    }

    private double processArea(Point2D a, Point2D b, Point2D c) {
        double sum;

        x1 = a.getX();
        x2 = b.getX();
        x3 = c.getX();
        y1 = a.getY();
        y2 = b.getY();
        y3 = c.getY();

        sum = Math.abs((x1*y2 + x2*y3 + x3*y1)-(x2*y1 + x3*y2 + x1*y3))/2;

        return sum;
    }
}
