import java.util.Scanner;
public class Main10F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }
        MyRectangle2D boundingRectangle = MyRectangle2D.getRectangle(points);
        System.out.printf("x, y: %.1f, %.1f\n", boundingRectangle.getX(), boundingRectangle.getY());
        System.out.printf("w, h: %.1f, %.1f\n", boundingRectangle.getWidth(), boundingRectangle.getHeight());
    }
}

class MyRectangle2D {

    private double x, y;
    private double width, height;

    public MyRectangle2D(double[][] point) {
        double maxX, maxY, minX, minY;
        maxX = maxY = Double.MIN_VALUE;
        minX = minY = Double.MAX_VALUE;
        int lenght = point.length;

        for(int i = 0;i<lenght;i++) {
            if(point[i][0] > maxX)
                maxX = point[i][0];
            if(point[i][1] > maxY)
                maxY = point[i][1];
            if(point[i][0] < minX)
                minX = point[i][0];
            if(point[i][1] < minY)
                minY = point[i][1];
        }

        x = (maxX + minX)/2;
        y = (maxY + minY)/2;

        width = maxX - minX;
        height = maxY - minY;

    }

    public static MyRectangle2D getRectangle(double[][] point) {
        return new MyRectangle2D(point);
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

}